package homework;

import java.util.ArrayList;

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
}