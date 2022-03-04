package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import javafx.geometry.Point2D;

/**
 * A class to manage entities in Hex
 */
public class EntityManager {
    /**
     * Spawns an entity of the specified type at the specified location
     * @param type the entity type
     * @param location where to spawn them
     */
    public static void spawnEntity(EntityType type, Point2D location) {
        FXGL.spawn(type.toString(), location);
    }
}
