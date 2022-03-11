package hex.entities;

import hex.entities.player.PlayerFactory;

/**
 * An enum to collect all general entity in Hex
 */
public enum EntityType {
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
