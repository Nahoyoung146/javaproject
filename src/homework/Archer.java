package homework;

public class Archer extends User {
	Archer(String name, int maxhp, int maxmp, int maxatk) {
		super(name, maxhp, maxmp, maxatk);
	}

	public void Skill(User[] user, Monster mon) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n아군들의 공격력이 증가하였습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setAtk(user[i].getAtk() + 50);
			System.out.println(user[i].getName() + "의 공격력 : " + user[i].getAtk());
			i++;
		}
		this.setMp(this.getMp() - 30);
	}

	public void Cross(Monster mon, int turn) {
		System.out.println("집중사격을(를) 사용했습니다.\n지속적으로 출혈데미지가 발생합니다.");
		mon.setHp(mon.getHp() - 30 * this.getLevel() - 5 * turn);
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}

	public void Bow(Monster mon) {
		System.out.println("헤드샷를(을) 사용했습니다.\n스킬의 효과로 상대방의 공격력이 반감됩니다.");
		mon.setHp(mon.getHp() - 30 * this.getLevel());
		mon.setAtk(mon.getAtk() / 2);
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp() + "\n적 공격력 : " + mon.getAtk());
	}
}