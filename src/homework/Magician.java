package homework;

public class Magician extends User {
	Magician() {
		super();
	}

	Magician(String name, int atk, int skillatk, String job) {
		super(name, atk, skillatk, job);
	}

	public void SkillWa(User user, Monster monster) {
		System.out.println(super.getName() + "이(가) 스킬을 시전했습니다\t적에게 상당한 피해를 입혔습니다.");
		monster.setHp(monster.getHp() - user.getSkillatk());
	}
}
