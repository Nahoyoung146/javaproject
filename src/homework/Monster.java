package homework;

import java.util.ArrayList;

public abstract class Monster extends Rpg implements Attack, Skill {
	private String species;
	private int difficulty;

	Monster() {
		super();
		this.species = "가나다";
		this.difficulty = 1;
	}

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

	public void attack(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2, int order3) {
		int i = 0;
		while (i < user.size()) {
			System.out.println(Mon.get(order)[order2].getName() + "이(가) 공격을 합니다.");
			user.get(i).setHp(user.get(i).getHp() - Mon.get(order)[order2].getAtk());
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}
	
	public abstract void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order,int order2);

	public String toString() {
		return "이름 : " + this.getName() + ", 체력 : " + this.getHp() + ", 공격력 : " + this.getAtk();
	}
}