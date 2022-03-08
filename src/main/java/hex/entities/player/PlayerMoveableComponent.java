package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import javafx.scene.input.KeyCode;

/**
 * A class to allow the player to control the movement of an entity
 */
public class PlayerMoveableComponent extends Component {
    // Assigned movement keys
    private static final KeyCode RIGHT_KEY = KeyCode.D;
    private static final KeyCode UP_KEY = KeyCode.W;
    private static final KeyCode LEFT_KEY = KeyCode.A;
    private static final KeyCode DOWN_KEY = KeyCode.S;

    private static final int MOVE_DELTA = 2; // pixels moved per movement

    // Register key events
    public PlayerMoveableComponent() {
        FXGL.onKey(UP_KEY, this::moveUp);
        FXGL.onKey(DOWN_KEY, this::moveDown);
        FXGL.onKey(LEFT_KEY, this::moveLeft);
        FXGL.onKey(RIGHT_KEY, this::moveRight);
    }


    public void moveRight() {
        getEntity().translateX(MOVE_DELTA);

        // Flip texture to face direction of movement
        getEntity().setScaleX(1);
    }

    public void moveUp() {
        getEntity().translateY(-MOVE_DELTA);
    }

    public void moveLeft() {
        getEntity().translateX(-MOVE_DELTA);

        // Flip texture to face direction of movement
        getEntity().setScaleX(-1);
    }

    public void moveDown() {
        getEntity().translateY(MOVE_DELTA);
    }
}