package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.Hex;
import hex.entities.spells.SpellType;
import javafx.geometry.Point2D;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * A component for the player to cast a spell
 */
public class PlayerCastingComponent extends Component {
    private boolean isOnCooldown;
    private static final double COUNTDOWN_INTERVAL = 100;


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
        if (!isOnCooldown) {
            isOnCooldown = true;
            SpellType spellType = Hex.getPlayer().getSelectedSpell();

            applyCooldownEffect();

            FXGL.spawn(spellType.toString(), getEntity().getCenter());
        }

    }

    private void applyCooldownEffect() {
        SpellType spellType = Hex.getPlayer().getSelectedSpell();

        StackPane spellNode = Hex.getPlayer().getSelectedSpellNode();

        // Create a cooldown effect
        Rectangle cooldownEffect = new Rectangle(
                PlayerSpellInventoryComponent.SPELL_SIZE,
                PlayerSpellInventoryComponent.SPELL_SIZE,
                new Color(1, 1, 1, 0.4)
        );

        // Calculate the number of pixels to reduce by each interval
        double sizeDelta = cooldownEffect.getHeight() / (spellType.getCooldown() / COUNTDOWN_INTERVAL);

        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();

        AtomicInteger runtime = new AtomicInteger();
        executorService.scheduleAtFixedRate(() -> {
            // Track how long we have been running
            runtime.addAndGet((int) COUNTDOWN_INTERVAL);

            // Reduce the size of the effect
            cooldownEffect.setHeight(cooldownEffect.getHeight() - sizeDelta);

            // If we have ran for the full cooldown length
            if (runtime.get() == spellType.getCooldown()) {
                // Take the player off cooldown
                isOnCooldown = false;

                // Remove the effect
                spellNode.getChildren().remove(cooldownEffect);

                // Stop the service
                executorService.shutdown();
            }
        }, 0, (long) COUNTDOWN_INTERVAL, TimeUnit.MILLISECONDS);

        // Add the effect to the inventory
        spellNode.getChildren().add(cooldownEffect);
    }
}
