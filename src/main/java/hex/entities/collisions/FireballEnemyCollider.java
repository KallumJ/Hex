package hex.entities.collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import hex.entities.EnemyType;
import hex.entities.EnemyWrapper;
import hex.entities.spells.SpellType;
import hex.entities.spells.fireball.FireballFactory;

/**
 * A collision handler for handling what happens when fireballs hit enemies
 */
public class FireballEnemyCollider extends CollisionHandler {
    public FireballEnemyCollider(EnemyType enemy) {
        super(SpellType.FIREBALL, enemy);
    }

    @Override
    protected void onCollisionBegin(Entity fireball, Entity enemy) {
        // Once fireball has hit an entity, we don't want it progressing further
        fireball.removeFromWorld();

        // Damage the goblin
        EnemyWrapper goblinWrapper = new EnemyWrapper(enemy);
        goblinWrapper.damage(FireballFactory.DAMAGE);
    }
}
