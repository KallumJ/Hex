package hex.entities.spells.fireball;

/**
 * An enum to catalog types of spells in Hex
 */
public enum SpellType {
    FIREBALL(FireballFactory.KEY);

    private final String key;

    SpellType(String key) {
        this.key = key;
    }

    @Override
    public String toString() {
        return key;
    }
}
