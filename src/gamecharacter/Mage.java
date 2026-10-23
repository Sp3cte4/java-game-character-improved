package gamecharacter;

public class Mage extends Game_Character {

    public Mage(String name) {
        super(name, 100, 30);
    }

    @Override
    public String attack() {
        return getName() + " casts multiple fireball!";
    }

    @Override
    public String passive() {
        return "Passive: Magic deals 200% for 3 seconds!";
    }

    @Override
    public String ultimate() {
        return getName() + " unleashes Divine Storm!!!";
    }
}