package hex.entities;

import com.almasb.fxgl.entity.Entity;
import hex.entities.components.EntityHealthComponent;

/**
 * A class to provide useful methods for enemy entities
 */
public class EnemyWrapper {
    private final Entity enemyEntity;

    public EnemyWrapper(Entity enemy) {
        this.enemyEntity = enemy;
    }

    public void damage(int damage) {
        enemyEntity.getComponent(EntityHealthComponent.class).damage(damage);
    }
}
