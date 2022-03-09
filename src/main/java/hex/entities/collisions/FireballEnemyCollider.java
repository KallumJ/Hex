package hex.entities.collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import hex.entities.EntityType;
import hex.entities.spells.fireball.SpellType;

/**
 * A collision handler for handling what happens when fireballs hit enemies
 */
public class FireballEnemyCollider extends CollisionHandler {
    public FireballEnemyCollider() {
        super(SpellType.FIREBALL, EntityType.ENEMY);
    }

    @Override
    protected void onCollisionBegin(Entity a, Entity b) {
        System.out.println("collided");
    }
}
