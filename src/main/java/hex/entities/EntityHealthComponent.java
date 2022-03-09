package hex.entities;

import com.almasb.fxgl.entity.component.Component;
import hex.Hex;

/**
 * A component to provide the entity health
 */
public class EntityHealthComponent extends Component {
    private int health;

    public EntityHealthComponent(int health) {
        this.health = health;
    }

    public void damage(int damage) {
        health = health - damage;

        if (health <= 0) {
            Hex.WAVE_MANAGER.removeEntity(getEntity());
        }
    }
}
