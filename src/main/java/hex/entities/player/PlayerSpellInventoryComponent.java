package hex.entities.player;

import com.almasb.fxgl.dsl.FXGL;
import com.almasb.fxgl.entity.component.Component;
import hex.entities.spells.SpellType;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.input.ScrollEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.util.ArrayList;
import java.util.List;

/**
 * A component for players to store and select spells
 */
public class PlayerSpellInventoryComponent extends Component {
    private static final SpellType STARTER = SpellType.FIREBALL;

    private final List<SpellType> spells;
    private final List<StackPane> spellNodes;
    private int selectedSpell;
    private final Rectangle selectedGUI;

    public PlayerSpellInventoryComponent() {
        this.spells = new ArrayList<>();
        this.spellNodes = new ArrayList<>();
        Rectangle selectedSquare = new Rectangle(40, 40, Color.TRANSPARENT);
        selectedSquare.setStroke(Color.LIGHTGRAY);
        this.selectedGUI = selectedSquare;

        // Start with starter spell
        addSpell(STARTER);
        addSpell(SpellType.WINDSTORM);
        setSelectedSpellGUI(0, 0);

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
        int previous = selectedSpell;

        if (selectedSpell == 0) {
            selectedSpell = spells.size() - 1;
        } else {
            selectedSpell--;
        }
        setSelectedSpellGUI(previous, selectedSpell);
    }

    private void incrementSelectedSpell() {
        int previous = selectedSpell;

        if (selectedSpell == spells.size() - 1) {
            selectedSpell = 0;
        } else {
            selectedSpell++;
        }
        setSelectedSpellGUI(previous, selectedSpell);
    }

    private void setSelectedSpellGUI(int previous, int selectedSpell) {
        spellNodes.get(previous).getChildren().remove(selectedGUI);
        spellNodes.get(selectedSpell).getChildren().add(selectedGUI);
    }

    public void addSpell(SpellType spellType) {
        spells.add(spellType);
        spellNodes.add(constructSpellNode(spellType));
    }

    private StackPane constructSpellNode(SpellType spellType) {
        StackPane spellContainer = new StackPane();
        spellContainer.getChildren().add(spellType.getView());

        return spellContainer;
    }

    public SpellType getSelectedSpell() {
        return spells.get(selectedSpell);
    }

    public Node getSpellInventoryGUI() {
        HBox container = new HBox();

        for (StackPane spellNode : spellNodes) {
            spellNode.setPadding(new Insets(20));
            container.getChildren().add(spellNode);
        }

        return container;
    }
}
