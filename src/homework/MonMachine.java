package homework;

public abstract class MonMachine extends Monster {
	MonMachine() {
		super();
	}

	MonMachine(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public abstract void Skill(User[] user, Monster[] monster, int order);
}