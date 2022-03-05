package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.scene.input.KeyCode;
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
                .type(EntityType.PLAYER)
                .viewWithBBox(new Rectangle(100, 100, Color.RED))
                .with(new CollidableComponent(true))
                .with(new PlayerBehaviour())
                .build();
    }
}

/**
 * A class to provide behaviour to the player entity
 */
class PlayerBehaviour extends Component {
    private static final int MOVE_DELTA = 5;

    // Register key events
    PlayerBehaviour() {
        FXGL.onKey(KeyCode.D, this::moveRight);
        FXGL.onKey(KeyCode.W, this::moveUp);
        FXGL.onKey(KeyCode.S, this::moveDown);
        FXGL.onKey(KeyCode.A, this::moveLeft);
    }

    public void moveRight() {
        getEntity().translateX(MOVE_DELTA);
    }

    public void moveUp() {
        getEntity().translateY(-MOVE_DELTA);
    }

    public void moveLeft() {
        getEntity().translateX(-MOVE_DELTA);
    }

    public void moveDown() {
        getEntity().translateY(MOVE_DELTA);
    }
}
