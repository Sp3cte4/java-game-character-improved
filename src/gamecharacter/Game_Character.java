
package gamecharacter;

public abstract class Game_Character {

    private String name;
    private int maxHealth;
    private int health;
    private int attackDamage;

    public Game_Character(String name, int maxHealth, int attackDamage) {

        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Character name cannot be empty.");
        }

        if (maxHealth <= 0 || attackDamage <= 0) {
            throw new IllegalArgumentException(
                    "Health and attack damage must be greater than zero.");
        }

        this.name = name.trim();
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attackDamage = attackDamage;
    }

    public String getName() {
        return name;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getAttackDamage() {
        return attackDamage;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public void takeDamage(int damage) {

        if (damage < 0) {
            throw new IllegalArgumentException(
                    "Damage cannot be negative.");
        }

        health = Math.max(0, health - damage);
    }

    public void heal(int amount) {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Healing cannot be negative.");
        }

        health = Math.min(maxHealth, health + amount);
    }

    public void restoreHealth() {
        health = maxHealth;
    }

    // Every character must implement these three skills.
    public abstract String attack();

    public abstract String passive();

    public abstract String ultimate();

    // Returns the character's class name.
    public String getCharacterType() {
        return getClass().getSimpleName();
    }

    @Override
    public String toString() {
        return name + " (" + getCharacterType() + ") - HP: "
                + health + "/" + maxHealth;
    }
    public void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new IllegalArgumentException(
                    "Character name cannot be empty.");
        }

        this.name = name.trim();
    }
}
