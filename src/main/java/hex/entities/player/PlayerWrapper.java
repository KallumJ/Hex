package hex.entities.player;

import com.almasb.fxgl.entity.Entity;
import hex.entities.Facing;

public class PlayerWrapper {
    private final Entity playerEntity;

    public PlayerWrapper(Entity playerEntity) {
        this.playerEntity = playerEntity;
    }

    public Facing getFacing() {
        return playerEntity.getComponent(PlayerFacingComponent.class).getFacing();
    }
}
