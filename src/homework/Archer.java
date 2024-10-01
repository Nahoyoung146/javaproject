package homework;

import java.util.ArrayList;

public class Archer extends User {
	Archer() {
		super();
	}

	Archer(String name, String job, String futurejob) {
		super(name, job, futurejob);
	}

	public void Skill(ArrayList<User> user, Monster[] monster, int order) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n아군들의 공격력이 증가하였습니다.");
		int i = 0;
		while (i < user.size()) {
			user.get(i).setAtk(user.get(i).getAtk() + 50);
			System.out.println(user.get(i).getName() + "의 공격력 : " + user.get(i).getAtk());
			i++;
		}
		this.setMp(this.getMp() - 30);
	}
}