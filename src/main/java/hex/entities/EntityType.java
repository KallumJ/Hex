package hex.entities;

/**
 * An enum to collect all the entity types in Hex
 */
public enum EntityType {
    ENEMY(EnemyFactory.KEY),
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
