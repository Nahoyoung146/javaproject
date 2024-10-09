package homework;

import java.util.ArrayList;

public class MachineThird extends MonMachine {
	MachineThird(String name, int hp, int atk, String species, int difficulty) {
		super(name, hp, atk, species, difficulty);
	}

	public void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\t적들의 체력이 10%만 남습니다.");
		int i = 0;
		while (i < user.size()) {
			user.get(i).setAtk(user.get(i).getHp() / 10);
			System.out.println(user.get(i).getName() + "의 체력 : " + user.get(i).getHp());
			i++;
		}
	}

	public void attack(User user, Monster mon) {

	};
}