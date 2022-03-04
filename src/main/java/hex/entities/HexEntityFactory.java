package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * Entity factory for producing entities
 */
public class HexEntityFactory implements EntityFactory {
    public static final String PLAYER_KEY = "player";

    @Spawns(PLAYER_KEY)
    public Entity spawnPlayer(SpawnData data) {
        return FXGL.entityBuilder(data)
                .view(new Rectangle(100, 100, Color.RED))
                .type(EntityType.PLAYER)
                .buildAndAttach();
     }
}
