package hex.entities.goblin;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import hex.entities.EnemyType;
import hex.entities.components.EnemyChaseComponent;
import hex.entities.components.EntityHealthComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

/**
 * An entity factory for producing Goblin entities
 */
public class GoblinFactory implements EntityFactory {
    public static final String KEY = "goblin";
    private static final int HEALTH = 20;
    private static final double SPEED = 1.9; //in px's per 10ms

    @Spawns(KEY)
    public Entity buildGoblin(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EnemyType.GOBLIN)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new CollidableComponent(true))
                .with(new EntityHealthComponent(HEALTH))
                .with(new EnemyChaseComponent(SPEED))
                .build();
    }
}
