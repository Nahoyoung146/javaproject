package homework;

import java.util.ArrayList;

public class MachineBoss extends MonMachine {
	MachineBoss(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적들의 체력이 10%만 남습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setAtk(user[i].getHp() / 10);
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
			i++;
		}
	}
}