package gamecharacter;

public class Assassin extends Game_Character {

	public Assassin(String name) {
		super(name, 120, 15);
	}

	@Override
	public String attack() {
		return getName() + " teleport in front the enemy and strike with both his daggers";
	}

	@Override
	public String passive() {
		return getName() + " Use a shadow step and strike the enemy behind";
	}

	@Override
	public String ultimate() {
		return getName() + " Can create multiple clones of shadows and can use the same attack and passive as the original abilities";
	}
	
}
