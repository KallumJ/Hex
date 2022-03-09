package hex.entities.collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import hex.entities.EntityType;
import hex.entities.goblin.GoblinWrapper;
import hex.entities.spells.SpellType;
import hex.entities.spells.fireball.FireballFactory;

/**
 * A collision handler for handling what happens when fireballs hit enemies
 */
public class FireballGoblinCollider extends CollisionHandler {
    public FireballGoblinCollider() {
        super(SpellType.FIREBALL, EntityType.GOBLIN);
    }

    @Override
    protected void onCollisionBegin(Entity fireball, Entity goblin) {
        // Once fireball has hit an entity, we don't want it progressing further
        fireball.removeFromWorld();

        // Damage the goblin
        GoblinWrapper goblinWrapper = new GoblinWrapper(goblin);
        goblinWrapper.damage(FireballFactory.DAMAGE);
    }
}
