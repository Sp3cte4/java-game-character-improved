
package gamecharacter;

public class Paladin extends Game_Character {

    public Paladin(String name) {
        super(name, 180, 15);
    }

    @Override
    public String attack() {
        return getName() + " strikes with a holy sword!";
    }

    @Override
    public String passive() {
        return getName() + "'absorb 100% of damage for 3 seconds";
    }

    @Override
    public String ultimate() {
        return getName() + " unleashes Divine Judgment!";
    }
    
    
}
