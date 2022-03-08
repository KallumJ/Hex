package hex.entities;

import hex.entities.goblin.GoblinFactory;
import hex.entities.player.PlayerFactory;

/**
 * An enum to collect all the entity types in Hex
 */
public enum EntityType {
    GOBLIN(GoblinFactory.KEY),
    PLAYER(PlayerFactory.KEY);


    private final String key;

    EntityType(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
