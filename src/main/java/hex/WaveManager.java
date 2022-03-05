package hex;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.time.TimerAction;
import hex.entities.EntityManager;
import hex.entities.EntityType;
import javafx.geometry.Point2D;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadLocalRandom;

public class WaveManager {
    private int currentWave;
    private final ThreadLocalRandom random;

    public WaveManager() {
        this.currentWave = 1;
        this.random = ThreadLocalRandom.current();
    }

    public void generateWave() {
        List<EntityType> enemiesInWave = new ArrayList<>();

        int numberOfEnemies = decideNumberOfEnemies();

        for (int i = 0; i < numberOfEnemies; i++) {
            enemiesInWave.add(generateRandomEnemy());
        }

        for (EntityType entity : enemiesInWave) {
            int x = random.nextInt(Hex.WIDTH);
            int y = random.nextInt(Hex.HEIGHT);

            EntityManager.spawnEntity(entity, new Point2D(x, y));
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
        EntityType[] allowedEntities = new EntityType[]{EntityType.ENEMY};
        int selectedEntity = random.nextInt(allowedEntities.length);
        return allowedEntities[selectedEntity];
    }

    private int decideNumberOfEnemies() {
        int mult = random.nextInt(currentWave + 3);
        return currentWave * mult;
    }
}
