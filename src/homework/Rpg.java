package homework;

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
}