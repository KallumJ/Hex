package hex.entities.collisions;

import com.almasb.fxgl.entity.Entity;
import com.almasb.fxgl.physics.CollisionHandler;
import hex.Hex;
import hex.entities.EntityType;

public class PlayerGoblinCollider extends CollisionHandler {
    public PlayerGoblinCollider() {
        super(EntityType.PLAYER, EntityType.GOBLIN);
    }

    @Override
    protected void onCollisionBegin(Entity player, Entity goblin) {
        Hex.WAVE_MANAGER.removeEntity(goblin);
    }
}
