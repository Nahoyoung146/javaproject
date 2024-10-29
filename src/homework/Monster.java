package homework;

public abstract class Monster extends Rpg implements Attackmon, Skillmon {
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

	public void attackmon(User[] user) {
		int i = 0;
		while (i < user.length) {
			if (user[i].getHp() <= 0) {
				i++;
				continue;
			}

			else {
				System.out.println(this.getName() + "이(가) 공격을 합니다.");
				user[i].setHp(user[i].getHp() - this.getAtk());
				System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
				if (user[i].getHp() <= 0) {
					user[i].setHp(0);
				}
				i++;
			}
		}
	}

	public abstract void Skillmon(User[] user);

	public String toString() {
		return "이름 : " + this.getName() + ", 체력 : " + this.getHp() + ", 공격력 : " + this.getAtk();
	}
}