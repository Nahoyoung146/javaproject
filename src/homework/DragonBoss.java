package homework;

import java.util.ArrayList;

public class DragonBoss extends MonDragon {
	DragonBoss(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill1(User[] user) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적에게 상당한 피해를 입혔습니다.");
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getHp() - 100);
			System.out.println(user[i].getName() + "의 체력 : " + user[i].getHp());
			i++;
		}
	}
}