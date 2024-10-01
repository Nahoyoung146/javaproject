package homework;

import java.util.ArrayList;

public class Monster extends Rpg implements Attack {
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

	public void attack(ArrayList<User> user, MonDragon[] dragon, int order, int order2) {
		int i = 0;
		while (i < user.size()) {
			System.out.println(dragon[order].getName() + "이(가) 공격을 합니다.");
			user.get(i).setHp(user.get(i).getHp() - dragon[order].getAtk());
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}

	public void attack(ArrayList<User> user, MonDemon[] demon, int order, int order2) {
		int i = 0;
		while (i < user.size()) {
			System.out.println(demon[order].getName() + "이(가) 공격을 합니다.");
			user.get(i).setHp(user.get(i).getHp() - demon[order].getAtk());
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}

	public void attack(ArrayList<User> user, MonMachine[] machine, int order, int order2) {
		int i = 0;
		while (i < user.size()) {
			System.out.println(machine[order].getName() + "이(가) 공격을 합니다.");
			user.get(i).setHp(user.get(i).getHp() - machine[order].getAtk());
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}

	public String toString() {
		return "이름 : " + this.getName() + ", 체력 : " + this.getHp() + ", 공격력 : " + this.getAtk();
	}
}