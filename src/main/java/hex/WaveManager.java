package hex;

import hex.entities.EntityManager;
import hex.entities.EntityType;
import javafx.geometry.Point2D;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class WaveManager {
    private int currentWave;
    private final List<EntityType> enemiesInWave;
    private final ThreadLocalRandom random;

    public WaveManager() {
        this.currentWave = 1;
        this.enemiesInWave = new ArrayList<>();
        this.random = ThreadLocalRandom.current();
    }

    public void generateWave() {
        int numberOfEnemies = decideNumberOfEnemies();

        for (int i = 0; i < numberOfEnemies; i++) {
            enemiesInWave.add(generateRandomEnemy());
        }

        for (EntityType entity : enemiesInWave) {
            int x = random.nextInt(Hex.WIDTH);
            int y = random.nextInt(Hex.HEIGHT);

            EntityManager.spawnEntity(entity, new Point2D(x, y));
        }
    }

    private EntityType generateRandomEnemy() {
        EntityType[] allowedEntities = new EntityType[]{};
        int selectedEntity = random.nextInt(allowedEntities.length);
        return allowedEntities[selectedEntity];
    }

    private int decideNumberOfEnemies() {
        int mult = random.nextInt(currentWave + 3);
        return currentWave * mult;
    }
}
