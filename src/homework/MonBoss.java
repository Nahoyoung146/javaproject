package homework;

public class MonBoss extends Monster {
	MonBoss() {
		super();
	}

	MonBoss(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void SkillBoss1(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적에게 상당한 피해를 입혔습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp()-100);
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
			i++;
		}
	}

	public void SkillBoss2(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다.\t적들의 공격력을 반감시킵니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setAtk(user[i].getAtk()/2);
			System.out.println(user[i].getName() + "의 공격력 : " + user[i].getAtk());
			i++;
		}

	}

	public void SkillBoss3(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적들의 체력이 10%만 남습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setAtk(user[i].getHp()/10);
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
			i++;
		}

	}
}