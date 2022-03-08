package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.entities.spells.fireball.SpellType;

import javafx.scene.input.ScrollEvent;

import java.util.ArrayList;
import java.util.List;

/**
 * A component for players to store and select spells
 */
public class PlayerSpellInventoryComponent extends Component {
    private static final SpellType STARTER = SpellType.FIREBALL;

    private final List<SpellType> spells;
    private int selectedSpell;

    public PlayerSpellInventoryComponent() {
        this.spells = new ArrayList<>();

        // Start with starter spell
        addSpell(STARTER);

        // Increment/decrement the spell based on scroll wheel movements
        FXGL.getInput().addEventHandler(ScrollEvent.SCROLL, scrollEvent -> {
            if (scrollEvent.getDeltaY() > 0 || scrollEvent.getDeltaX() > 0) {
                incrementSelectedSpell();
            } else {
                decrementSelectedSpell();
            }
        });
    }

    private void decrementSelectedSpell() {
        if (selectedSpell == 0) {
            selectedSpell = spells.size() - 1;
        } else {
            selectedSpell--;
        }
    }

    private void incrementSelectedSpell() {
        if (selectedSpell == spells.size() - 1) {
            selectedSpell = 0;
        } else {
            selectedSpell++;
        }
    }

    public void addSpell(SpellType spellType) {
        spells.add(spellType);
    }

    public SpellType getSelectedSpell() {
        return spells.get(selectedSpell);
    }
}
