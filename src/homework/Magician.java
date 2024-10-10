package homework;

import java.util.ArrayList;

public class Magician extends User {
	Magician(String name, int maxhp, int maxmp, int maxatk) {
		super(name, maxhp, maxmp, maxatk);
	}

	public void Skill(User[] user, Monster mon) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n아군들의 체력이 회복되었습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp() + 50);
			if (user[i].getHp() >= user[i].getMaxhp()) {
				user[i].setHp(user[i].getMaxhp());
			}
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
			i++;
		}
		this.setMp(this.getMp() - 30);
	}
}