package hex.entities;

import hex.entities.goblin.GoblinFactory;

/**
 * An enum to collect all enemy entities in Hex
 */
public enum EnemyType {
    GOBLIN(GoblinFactory.KEY);

    private final String key;

    EnemyType(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
