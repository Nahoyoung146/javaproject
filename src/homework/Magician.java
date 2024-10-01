package homework;

import java.util.ArrayList;

public class Magician extends User {
	Magician() {
		super();
	}

	Magician(String name, String job, String futurejob) {
		super(name, job, futurejob);
	}

	public void Skill(ArrayList<User> user, Monster[] monster, int order) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n아군들의 체력이 회복되었습니다.");
		int i = 0;
		while (i < user.size()) {
			user.get(i).setHp(user.get(i).getHp() + 50);
			if (user.get(i).getHp() >= user.get(i).getMaxhp()) {
				user.get(i).setHp(user.get(i).getMaxhp());
			}
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
		this.setMp(this.getMp() - 30);
	}
}