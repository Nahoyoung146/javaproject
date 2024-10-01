package homework;

import java.util.ArrayList;

public class Warrior extends User {
	Warrior() {
		super();
	}

	Warrior(String name, String job, String futurejob) {
		super(name, job, futurejob);
	}

	public void Skill(ArrayList<User> user, Monster[] monster, int order) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n적에게 상당한 피해를 입혔습니다.");
		monster[order].setHp(monster[order].getHp() - this.getSkillatk());
		this.setMp(this.getMp() - 30);
		System.out.println("적 체력 : " + monster[order].getHp());
	}
}