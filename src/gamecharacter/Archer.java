package gamecharacter;

public class Archer extends Game_Character {
	
	public Archer(String name) {
		super(name, 100, 15);
	}

	@Override
	public String attack() {
		return getName() + " fires a homing arrow that follows the enemy for 5 seconds!";
	}

	@Override
	public String passive() {
		return getName() + " leaps into the air and fires a rain of arrows for 3 seconds!";
	}

	@Override
	public String ultimate() {
		return getName() + " Unleashes a barrage of arrows";
	}
	
	
	
	
	
}
