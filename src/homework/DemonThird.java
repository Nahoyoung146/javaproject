package homework;

import java.util.ArrayList;

public class DemonThird extends MonDemon {
	DemonThird() {
		super();
	}

	DemonThird(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill(ArrayList<User> user, Monster[] monster, int order) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다.\t적들의 공격력을 반감시킵니다.");
		int i = 0;
		while (i < user.size()) {
			user.get(i).setAtk(user.get(i).getAtk() / 2);
			System.out.println(user.get(i).getName() + "의 공격력 : " + user.get(i).getAtk());
			i++;
		}
	}
}