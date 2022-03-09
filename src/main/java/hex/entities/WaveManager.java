package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import hex.Hex;
import javafx.geometry.Point2D;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class WaveManager {
    private static final String CURRENT_WAVE_STR = "Current Wave: %d";
    private final List<EntityType> enemiesInWave;
    private final Text currentWaveText;
    private int currentWave;

    public WaveManager() {
        this.currentWave = 1;
        this.enemiesInWave = new ArrayList<>();
        this.currentWaveText = new Text();

        currentWaveText.setFill(Color.WHITE);
        currentWaveText.setTranslateX(100);
        currentWaveText.setTranslateY(100);
        currentWaveText.setStyle("-fx-font-size: 32");

        // Use executor service as FXGL hasnt been initalised yet
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.scheduleAtFixedRate(() -> currentWaveText.setText(String.format(CURRENT_WAVE_STR, currentWave)), 0, 500, TimeUnit.MILLISECONDS);
    }

    public void generateWave() {
        int numberOfEnemies = decideNumberOfEnemies();

        for (int i = 0; i < numberOfEnemies; i++) {
            enemiesInWave.add(generateRandomEnemy());
        }

        for (EntityType entity : enemiesInWave) {
            int x = FXGL.random(0, Hex.WIDTH);
            int y = FXGL.random(0, Hex.HEIGHT);

            FXGL.spawn(entity.toString(), new Point2D(x, y));
        }


        FXGL.run(() -> {
            if (enemiesInWave.isEmpty()) {
                if (currentWave % 5 != 0) {
                    currentWave++;
                    generateWave();
                }
            }
        }, Duration.millis(500));
    }

    private EntityType generateRandomEnemy() {
        EntityType[] allowedEntities = new EntityType[]{EntityType.GOBLIN};
        int selectedEntity = FXGL.random(0, allowedEntities.length - 1);
        return allowedEntities[selectedEntity];
    }

    private int decideNumberOfEnemies() {
        int mult = FXGL.random(1, 3);
        return currentWave + mult;
    }

    public Text getCurrentWaveText() {
        return currentWaveText;
    }

    public void removeEntity(Entity entity) {
        EntityType entityType = (EntityType) entity.getType();
        enemiesInWave.remove(entityType);
        entity.removeFromWorld();
    }
}
