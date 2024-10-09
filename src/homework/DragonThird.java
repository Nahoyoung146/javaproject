package homework;

import java.util.ArrayList;

public class DragonThird extends MonDragon {
	DragonThird(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적에게 상당한 피해를 입혔습니다.");
		int i = 0;
		while (i < user.size()) {
			user.get(i).setHp(user.get(i).getHp() - 100);
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}

	public void attack(User user, Monster mon) {

	};
}