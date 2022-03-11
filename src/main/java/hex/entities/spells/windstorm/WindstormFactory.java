package hex.entities.spells.windstorm;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.dsl.components.ProjectileComponent;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import hex.Hex;
import javafx.scene.Node;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class WindstormFactory implements EntityFactory {
    public static final String KEY = "windstorm";
    private static final int SPEED = 500;

    @Spawns(KEY)
    public Entity buildWindstorm(SpawnData spawnData) {
        return FXGL.entityBuilder(spawnData)
                .viewWithBBox(getView())
                .with(new ProjectileComponent(Hex.getPlayer().getCastingTowardsPoint(), SPEED))
                .with(new CollidableComponent(true))
                .build();
    }

    public static Node getView() {
        return new Rectangle(10, 10, Color.YELLOW);
    }
}
