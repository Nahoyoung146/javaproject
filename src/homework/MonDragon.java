package homework;

public abstract class MonDragon extends Monster {
	MonDragon() {
		super();
	}

	MonDragon(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public abstract void Skill(User[] user, Monster[] monster, int order);
}