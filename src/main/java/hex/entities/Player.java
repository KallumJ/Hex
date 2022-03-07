package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import com.almasb.fxgl.input.Input;
import com.almasb.fxgl.input.InputModifier;
import com.almasb.fxgl.input.UserAction;
import hex.util.PressedKeySet;
import javafx.geometry.Point2D;
import javafx.geometry.Point3D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;
import org.jetbrains.annotations.NotNull;

import java.util.List;


/**
 * Entity factory for producing Player entities
 */
public class Player implements EntityFactory {
    public static final String KEY = "player";
    private static final String IMG = "player.png";


    @Spawns(KEY)
    public Entity buildPlayer(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .viewWithBBox(IMG)
                .with(new CollidableComponent(true))
                .with(new PlayerBehaviour())
                .build();
    }
}

/**
 * A class to provide behaviour to the player entity
 */
class PlayerBehaviour extends Component {
    private static final KeyCode RIGHT_KEY = KeyCode.D;
    private static final KeyCode UP_KEY = KeyCode.W;
    private static final KeyCode LEFT_KEY = KeyCode.A;
    private static final KeyCode DOWN_KEY = KeyCode.S;
    private static final int MOVE_DELTA = 2;

    private final PressedKeySet pressedKeys;
    private Facing facing = Facing.RIGHT;


    // Register key events
    PlayerBehaviour() {
        this.pressedKeys = new PressedKeySet();

        Input gameInput = FXGL.getInput();

        gameInput.addAction(new UserAction("Move Right") {
            @Override
            protected void onActionBegin() {
                pressedKeys.add(RIGHT_KEY);
            }

            @Override
            protected void onActionEnd() {
                pressedKeys.remove(RIGHT_KEY);
            }
        }, RIGHT_KEY);

        gameInput.addAction(new UserAction("Move Up") {
            @Override
            protected void onActionBegin() {
                pressedKeys.add(UP_KEY);
            }

            @Override
            protected void onActionEnd() {
                pressedKeys.remove(UP_KEY);
            }
        }, UP_KEY);

        gameInput.addAction(new UserAction("Move Down") {
            @Override
            protected void onActionBegin() {
                pressedKeys.add(DOWN_KEY);
            }

            @Override
            protected void onActionEnd() {
                pressedKeys.remove(DOWN_KEY);
            }
        }, DOWN_KEY);

        gameInput.addAction(new UserAction("Move Left") {
            @Override
            protected void onActionBegin() {
                pressedKeys.add(LEFT_KEY);
            }

            @Override
            protected void onActionEnd() {
                pressedKeys.remove(LEFT_KEY);
            }
        }, LEFT_KEY);

        FXGL.run(this::movePlayer, Duration.millis(10));
    }

    private void movePlayer() {
        facing = determineFacing();

        switch (facing) {
            case UP -> moveUp();
            case DOWN -> moveDown();
            case LEFT -> moveLeft();
            case RIGHT -> moveRight();
            case DOWN_LEFT -> moveDownLeft();
            case DOWN_RIGHT -> moveDownRight();
            case UP_LEFT -> moveUpLeft();
            case UP_RIGHT -> moveUpRight();
        }
    }

    private Facing determineFacing() {
        KeyCode key1 = pressedKeys.getKey1();
        KeyCode key2 = pressedKeys.getKey2();
        List<KeyCode> keys = pressedKeys.getPressedKeys();

        if (key1 != null) {
            if (key1.equals(key2)) {
                if (key1.equals(UP_KEY)) {
                    return Facing.UP;
                } else if (key1.equals(DOWN_KEY)) {
                    return Facing.DOWN;
                } else if (key1.equals(LEFT_KEY)) {
                    return Facing.LEFT;
                } else {
                    return Facing.RIGHT;
                }
            } else {
                if (keys.contains(UP_KEY) && keys.contains(RIGHT_KEY)) {
                    return Facing.UP_RIGHT;
                } else if (keys.contains(UP_KEY) && keys.contains(LEFT_KEY)) {
                    return Facing.UP_LEFT;
                } else if (keys.contains(DOWN_KEY) && keys.contains(RIGHT_KEY)) {
                    return Facing.DOWN_RIGHT;
                } else {
                    return Facing.DOWN_LEFT;
                }
            }
        }

        return facing;
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

    public void moveUpLeft() {
        getEntity().translateY(-MOVE_DELTA);
        getEntity().translateX(-MOVE_DELTA);
    }

    public void moveUpRight() {
        getEntity().translateY(-MOVE_DELTA);
        getEntity().translateX(MOVE_DELTA);
    }

    public void moveDownLeft() {
        getEntity().translateY(MOVE_DELTA);
        getEntity().translateX(-MOVE_DELTA);
    }

    public void moveDownRight() {
        getEntity().translateY(MOVE_DELTA);
        getEntity().translateX(MOVE_DELTA);
    }
}
