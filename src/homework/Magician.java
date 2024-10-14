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

	public void Wand(Monster mon) {
		System.out.println("역지사지을(를) 사용했습니다.\n상대방의 공격력만큼 상대방의 체력이 감소합니다.");
		mon.setHp(mon.getHp() - mon.getAtk());
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}

	public void Broom(Monster mon) {
		System.out.println("난장판 만들기을(를) 사용했습니다.\n상대방의 체력과 공격력이 바뀝니다.");
		mon.setHp(mon.getAtk());
		mon.setAtk(mon.getHp());
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}
}