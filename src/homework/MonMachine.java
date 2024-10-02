package homework;

import java.util.ArrayList;

public abstract class MonMachine extends Monster implements Skill {
	MonMachine() {
		super();
	}

	MonMachine(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public abstract void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order,int order2);
}