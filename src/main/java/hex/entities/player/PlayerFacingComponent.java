package hex.entities.player;


import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.entities.Facing;
import javafx.geometry.Point2D;
import javafx.util.Duration;

public class PlayerFacingComponent extends Component {
    private static final int CHECK_FACING_INTERVAL = 10; // in ms

    private Point2D prevPos;
    private Facing facing = Facing.RIGHT;

    public PlayerFacingComponent() {
        FXGL.run(() -> facing = determineFacing(), Duration.millis(CHECK_FACING_INTERVAL));
    }

    public Facing getFacing() {
        return facing;
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
                return facing;
            }
        }
    }
}