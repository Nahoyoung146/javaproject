package homework;

import java.util.ArrayList;

public abstract class Monster extends Rpg implements Attack, Skill {
	private String species;
	private int difficulty;

	Monster(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk);
		this.species = species;
		this.difficulty = difficulty;
	}

	public String getSpecies() {
		return species;
	}

	public int getDifficulty() {
		return difficulty;
	}

	public void attack1(User[] user, Monster mon) {
		int i = 0;
		while (i < user.length) {
			if (user[i].getHp() <= 0) {
				i++;
				continue;
			}

			else {
				System.out.println(mon.getName() + "이(가) 공격을 합니다.");
				user[i].setHp(user[i].getHp() - mon.getAtk());
				System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
				i++;
			}

		}
	}

	public abstract void attack(User user, Monster mon);

	public abstract void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2);

	public String toString() {
		return "이름 : " + this.getName() + ", 체력 : " + this.getHp() + ", 공격력 : " + this.getAtk();
	}
}