package hex.entities;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.entity.EntityFactory;
import com.almasb.fxgl.entity.SpawnData;
import com.almasb.fxgl.entity.Spawns;
import com.almasb.fxgl.entity.component.Component;
import com.almasb.fxgl.entity.components.CollidableComponent;
import javafx.geometry.Point2D;
import javafx.scene.input.KeyCode;
import javafx.util.Duration;


/**
 * Entity factory for producing Player entities
 */
public class Player implements EntityFactory {
    public static final String KEY = "player";
    private static final String IMG = "player.png";

    private Facing facing = Facing.RIGHT;

    @Spawns(KEY)
    public Entity buildPlayer(SpawnData data) {
        return FXGL.entityBuilder(data)
                .type(EntityType.PLAYER)
                .viewWithBBox(IMG)
                .with(new CollidableComponent(true))
                .with(new PlayerBehaviour(this))
                .build();
    }

    public void setFacing(Facing facing) {
        this.facing = facing;
    }

    public Facing getFacing() {
        return facing;
    }
}

/**
 * A class to provide behaviour to the player entity
 */
class PlayerBehaviour extends Component {
    // Assigned movement keys
    private static final KeyCode RIGHT_KEY = KeyCode.D;
    private static final KeyCode UP_KEY = KeyCode.W;
    private static final KeyCode LEFT_KEY = KeyCode.A;
    private static final KeyCode DOWN_KEY = KeyCode.S;

    private static final int MOVE_DELTA = 2; // pixels moved per movement
    private static final int CHECK_FACING_INTERVAL = 10; // in ms

    private Point2D prevPos;
    private final Player player;

    // Register key events
    PlayerBehaviour(Player player) {
        this.player = player;

        FXGL.onKey(UP_KEY, this::moveUp);
        FXGL.onKey(DOWN_KEY, this::moveDown);
        FXGL.onKey(LEFT_KEY, this::moveLeft);
        FXGL.onKey(RIGHT_KEY, this::moveRight);

        FXGL.run(() -> player.setFacing(determineFacing()), Duration.millis(CHECK_FACING_INTERVAL));
    }

    private Facing determineFacing() {
        // Get the players current position
        Point2D currentPos = getEntity().getPosition();

        // If there is no previous movement, set it to this
        if (prevPos == null) {
            prevPos = currentPos;
        }

        // Get the difference between the previous pos and the current pos
        Point2D diff = currentPos.subtract(prevPos);

        // Set the previous pos to this ps
        prevPos = currentPos;

        // Determine which direction the player is facing based on the pixels difference since last prev position
        double diffX = diff.getX();
        double diffY = diff.getY();

        if (diffY < 0) {
            if (diffX == 0) {
                return Facing.UP;
            } else if (diffX > 0) {
                return Facing.UP_RIGHT;
            } else {
                return Facing.UP_LEFT;
            }
        } else if (diffY > 0) {
            if (diffX == 0) {
                return Facing.DOWN;
            } else if (diffX > 0) {
                return Facing.DOWN_RIGHT;
            } else {
                return Facing.DOWN_LEFT;
            }
        } else {
            if (diffX < 0) {
                return Facing.LEFT;
            } else if (diffX > 0) {
                return Facing.RIGHT;
            } else {
                // If player has not moved, they are facing whatever direction they were previously
                return player.getFacing();
            }
        }
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
