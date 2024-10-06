package homework;

import java.util.ArrayList;

public class Rpg {
	private String name;
	private int hp, mp, atk;

	Rpg() {
		this.name = "가나다";
		this.hp = 0;
		this.mp = 0;
		this.atk = 0;
	}

	Rpg(String name) {
		this.name = name;
		this.hp = 1000;
		this.mp = 100;
		this.atk = 10;
	}

	Rpg(String name, int atk) {
		this.name = name;
		this.hp = 1000;
		this.mp = 100;
		this.atk = atk;
	}

	Rpg(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.mp = 0;
		this.atk = atk;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public static boolean deathuser(ArrayList<User> user) { // abstract death를 만들어서 오버라이딩하여 사용하는 것은 어떨까?
		int sum = 0;
		int i = 0;
		while (i < user.size()) {
			sum += user.get(i).getHp();
			i++;
		}

		if (sum <= 0)
			return true;

		return false;
	}

	public static boolean deathmonster(ArrayList<Monster[]> Mon, int order, int order2) {// abstract death를 만들어서 오버라이딩하여 사용하는 것은 어떨까?
		while (order2 < Mon.get(order).length) {
			if (Mon.get(order)[order2].getHp() <= 0)
				return true;
			order2++;
		}
		return false;
	}
}