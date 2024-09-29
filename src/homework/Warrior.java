package homework;

public class Warrior extends User {
	Warrior() {
		super();
	}

	Warrior(String name, String job) {
		super(name, job);
	}

	public void SkillWa(User user, Monster monster) {
		System.out.println(super.getName() + "이(가) 스킬을 시전했습니다\t적에게 상당한 피해를 입혔습니다.");
		monster.setHp(monster.getHp() - user.getSkillatk());
		System.out.println("적 체력 : " + monster.getHp());
	}
}