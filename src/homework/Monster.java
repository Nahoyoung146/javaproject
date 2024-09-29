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

	public void attack(User user, Monster monster) {
		System.out.println(monster.getName() + "이가 공격을 합니다.");
		monster.setHp(user.getHp() - monster.getAtk());
	}
}