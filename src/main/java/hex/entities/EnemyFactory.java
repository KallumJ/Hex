package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;


public class EnemyFactory implements EntityFactory {
    public static final String KEY = "enemy";

    @Spawns(KEY)
    public Entity buildEnemy(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.ENEMY)
                .viewWithBBox(new Rectangle(20, 20, Color.BLUE))
                .with(new CollidableComponent(true))
                .build();
    }
}
