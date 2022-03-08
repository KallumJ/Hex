package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.Hex;
import hex.entities.spells.fireball.SpellType;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;

/**
 * A component for the player to cast a spell
 */
public class PlayerCastingComponent extends Component {

    public PlayerCastingComponent() {
        FXGL.getInput().addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEvent -> {
            // Set the point we are casting towards
            Point2D pointClicked = new Point2D(mouseEvent.getX(), mouseEvent.getY());
            Point2D castingTowards = pointClicked.subtract(getEntity().getCenter());
            Hex.getPlayer().setCastingTowardsPoint(castingTowards);

            this.castSpell();
        });
    }

    private void castSpell() {
        SpellType spellType = Hex.getPlayer().getSelectedSpell();

        FXGL.spawn(spellType.toString(), getEntity().getCenter());
    }
}
