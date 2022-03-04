package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Entity factory for producing Player entities
 */
public class PlayerFactory implements EntityFactory {
    public static final String KEY = "player";

    @Spawns(KEY)
    public Entity buildPlayer(SpawnData data) {
        return FXGL.entityBuilder(data)
                .view(new Rectangle(100, 100, Color.RED))
                .type(EntityType.PLAYER)
                .buildAndAttach();
    }
}
