package hex.entities.spells;

import hex.entities.spells.fireball.FireballFactory;
import hex.entities.spells.windstorm.WindstormFactory;
import javafx.scene.Node;

/**
 * An enum to catalog types of spells in Hex
 */
public enum SpellType {
    FIREBALL(FireballFactory.KEY, FireballFactory.getView(), 2000),
    WINDSTORM(WindstormFactory.KEY, WindstormFactory.getView(), 5000);

    private final String key;
    private final Node view;
    private final int cooldown;

    SpellType(String key, Node view, int cooldown) {
        this.key = key;
        this.view = view;
        this.cooldown = cooldown;
    }

    @Override
    public String toString() {
        return key;
    }

    public Node getView() {
        return view;
    }

    public int getCooldown() {
        return cooldown;
    }
}
