package homework;

import java.util.ArrayList;

public class Warrior extends User {
	Warrior(String name, int maxhp, int maxmp, int atk, String futurejob) {
		super(name, maxhp, maxmp, atk, futurejob);
	}

	public void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n적에게 상당한 피해를 입혔습니다.");
		Mon.get(order)[order2].setHp(Mon.get(order)[order2].getHp() - this.getSkillatk());
		this.setMp(this.getMp() - 30);
		System.out.println("적 체력 : " + Mon.get(order)[order2].getHp());
	}
}