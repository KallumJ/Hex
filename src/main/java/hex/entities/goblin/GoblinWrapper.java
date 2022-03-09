package hex.entities.goblin;

import com.almasb.fxgl.entity.Entity;
import hex.entities.EntityHealthComponent;

/**
 * A class to provide useful methods for the goblin entity
 */
public class GoblinWrapper {
    private final Entity goblinEntity;

    public GoblinWrapper(Entity goblinEntity) {
        this.goblinEntity = goblinEntity;
    }

    public void damage(int damage) {
        goblinEntity.getComponent(EntityHealthComponent.class).damage(damage);
    }
}
