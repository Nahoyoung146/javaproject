package homework;

import java.util.ArrayList;

public class NpcInfo extends Npc {
	NpcInfo() {
		super();
	}

	NpcInfo(String name) {
		super(name);
	}

	public static void buff(ArrayList<User> user) {
		System.out.println("길잡이npc가 등장했습니다.\n일정확률로 버프가 적용됩니다.");
		int a = (int) (Math.random() * 3) + 1;
		switch (a) {
		case 1:
			System.out.println("모험가들 공격력 증가");
			int i = 0;
			while (i < user.size()) {
				user.get(i).setAtk(user.get(i).getAtk());
			}
			break;
		case 2:
			System.out.println("모험가들 Hp과(와) Mp 증가");
			i = 0;
			while (i < user.size()) {
				user.get(i).setMaxhp(user.get(i).getMaxhp() + 100);
				user.get(i).setMaxmp(user.get(i).getMaxmp() + 50);
			}
			break;
		default:
			System.out.println("아쉽지만 아무 버프도 받지 못했습니다.");
		break;
		}
	}
}