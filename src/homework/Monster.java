package homework;

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

	public void attack(User[] user, MonDragon[] dragon, int order) {
		System.out.println(dragon[order].getName() + "이가 공격을 합니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp() - dragon[i].getAtk());
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
		}
	}

	public void attack(User[] user, MonDemon[] demon, int order) {
		System.out.println(demon[order].getName() + "이가 공격을 합니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp() - demon[i].getAtk());
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
		}
	}

	public void attack(User[] user, MonMachine[] machine, int order) {
		System.out.println(machine[order].getName() + "이가 공격을 합니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp() - machine[i].getAtk());
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
		}
	}

	public String toString() {
		return "이름 : " + this.getName() + ", 체력 : " + this.getHp() + ", 공격력 : " + this.getAtk();
	}
}