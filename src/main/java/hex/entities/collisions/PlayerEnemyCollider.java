package hex.entities.collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import hex.Hex;
import hex.entities.EntityType;

public class PlayerEnemyCollider extends CollisionHandler {
    public PlayerEnemyCollider() {
        super(EntityType.PLAYER, EntityType.ENEMY);
    }

    @Override
    protected void onCollisionBegin(Entity player, Entity enemy) {
        Hex.WAVE_MANAGER.removeEntity(enemy);
    }
}
