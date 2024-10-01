package homework;

import java.util.ArrayList;

public abstract class MonDemon extends Monster implements Skill {
	MonDemon() {
		super();
	}

	MonDemon(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public abstract void Skill(ArrayList<User> user, Monster[] monster, int order);
}