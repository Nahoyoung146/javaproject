package homework;

public class Archer extends User {
	Archer() {
		super();
	}

	Archer(String name, int atk, int skillatk, String job) {
		super(name, atk, skillatk, job);
	}

	public void SkillWa(User user1, User user2, User user3) {
		System.out.println(super.getName() + "이(가) 스킬을 시전했습니다\t아군들의 공격력이 증가하였습니다.");
		int i = 0;
		while (i < 3) {

			i++;
		}
	}
}