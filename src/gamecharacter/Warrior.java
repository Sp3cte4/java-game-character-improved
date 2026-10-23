package gamecharacter;

public class Warrior extends Game_Character {

    public Warrior(String name) {
        super(name, 150, 20);
    }

    @Override
    public String attack() {
        return getName() + " swings a mighty sword!";
    }

    @Override
    public String passive() {
        return "Passive: Iron Will reduces incoming damage!";
    }

    @Override
    public String ultimate() {
        return getName() + " uses Divine Judgment!!!";
    }
}