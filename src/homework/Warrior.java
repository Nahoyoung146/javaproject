package homework;

import java.util.ArrayList;

public class Warrior extends User {
	Warrior(String name, int maxhp, int maxmp, int maxatk) {
		super(name, maxhp, maxmp, maxatk);
	}

	public void Skill(User[] user, Monster mon) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n적에게 상당한 피해를 입혔습니다.");
		mon.setHp(mon.getHp() - this.getSkillatk());
		this.setMp(this.getMp() - 30);
		System.out.println("적 체력 : " + mon.getHp());
	}
}