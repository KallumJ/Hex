package hex.entities.spells;

import hex.entities.spells.fireball.FireballFactory;
import hex.entities.spells.windstorm.WindstormFactory;
import javafx.scene.Node;

/**
 * An enum to catalog types of spells in Hex
 */
public enum SpellType {
    FIREBALL(FireballFactory.KEY, FireballFactory.getView()),
    WINDSTORM(WindstormFactory.KEY, WindstormFactory.getView());

    private final String key;
    private final Node view;

    SpellType(String key, Node view) {
        this.key = key;
        this.view = view;
    }

    @Override
    public String toString() {
        return key;
    }

    public Node getView() {
        return view;
    }
}
