package hex.entities.goblin;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import hex.entities.EntityType;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * An entity factory for producing Goblin entities
 */
public class GoblinFactory implements EntityFactory {
    public static final String KEY = "goblin";

    @Spawns(KEY)
    public Entity buildGoblin(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.GOBLIN)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new CollidableComponent(true))
                .build();
    }
}
