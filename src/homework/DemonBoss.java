package homework;

import java.util.ArrayList;

public class DemonBoss extends MonDemon {
	DemonBoss(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다.\t적들의 공격력을 반감시킵니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setAtk(user[i].getAtk() / 2);
			System.out.println(user[i].getName() + "의 공격력 : " + user[i].getAtk());
			i++;
		}
	}
}