package hex.entities.player;

import com.almasb.fxgl.entity.Entity;
import hex.entities.Facing;
import hex.entities.spells.fireball.SpellType;
import javafx.geometry.Point2D;

/**
 * A wrapper class for the player entity to provide more useful methods
 */
public class PlayerWrapper {

    private final Entity playerEntity;
    private Point2D castingTowards;

    public PlayerWrapper(Entity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public Facing getFacing() {
        return playerEntity.getComponent(PlayerFacingComponent.class).getFacing();
    }

    public SpellType getSelectedSpell() {
        return playerEntity.getComponent(PlayerSpellInventoryComponent.class).getSelectedSpell();
    }

    public Point2D getPosition() {
        return playerEntity.getCenter();
    }

    public Point2D getFacingAsPoint2D() {
        return switch (getFacing()) {
            case UP -> new Point2D(0, -1);
            case UP_RIGHT -> new Point2D(1, -1);
            case UP_LEFT -> new Point2D(-1, -1);
            case DOWN -> new Point2D(0, 1);
            case DOWN_LEFT -> new Point2D(-1, 1);
            case DOWN_RIGHT -> new Point2D(1, 1);
            case LEFT -> new Point2D(-1, 0);
            default -> new Point2D(1, 0);
        };
    }

    public void setCastingTowardsPoint(Point2D point) {
        this.castingTowards = point;
    }

    public Point2D getCastingTowardsPoint() {
        return castingTowards;
    }
}
