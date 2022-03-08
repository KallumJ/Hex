package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import hex.entities.EntityType;


/**
 * Entity factory for producing Player entities
 */
public class PlayerFactory implements EntityFactory {
    public static final String KEY = "player";
    private static final String IMG = "player.png";

    @Spawns(KEY)
    public Entity buildPlayer(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .viewWithBBox(IMG)
                .with(new CollidableComponent(true))
                .with(new PlayerMoveableComponent())
                .with(new PlayerFacingComponent())
                .build();
    }
}