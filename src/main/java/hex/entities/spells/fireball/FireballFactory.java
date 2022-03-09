package hex.entities.spells.fireball;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import hex.Hex;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

/**
 * An entity factory for producing fireball entities
 */
public class FireballFactory implements EntityFactory {
    public static final String KEY = "fireball";
    public static final int DAMAGE = 4;
    private static final int SPEED = 1000;

    @Spawns(KEY)
    public Entity buildFireball(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(SpellType.FIREBALL)
                .viewWithBBox(new Circle(10, 10, 10, Color.ORANGE))
                .with(new ProjectileComponent(Hex.getPlayer().getCastingTowardsPoint(), SPEED))
                .with(new CollidableComponent(true))
                .build();
    }
}
