package homework;

import java.util.ArrayList;

public class NpcItems extends Npc {
	public static void iteminfo(ArrayList<Item[]> item, int order) {
		System.out.println("아이템Npc가 등장했습니다");
		System.out.println("========== 전사 ==========");
		for (int i = 0; i < item.get(order).length; i++) {
			System.out.println(item.get(order)[i]);
		}

		System.out.println("========== 궁수 ==========");
		for (int i = 0; i < item.get(order + 1).length; i++) {
			System.out.println(item.get(order + 1)[i]);
		}

		System.out.println("========== 마법사 ==========");
		for (int i = 0; i < item.get(order + 2).length; i++) {
			System.out.println(item.get(order + 2)[i]);
		}
	}

	public static void itemcanbuy(ArrayList<Item[]> item, ArrayList<User> user, int order1) {

		System.out.println("구매 가능 물품\n금액 부족시 아무 아이템도 보이지 않음");
		System.out.println("========== 전사 ==========");
		for (int j = 0; j < item.get(order1).length; j++) {
			if (user.get(order1).getMoney() >= item.get(order1)[j].getPrice()) {
				System.out.println(item.get(order1)[j]);
			}
		}

		System.out.println("========== 궁수 ==========");
		for (int j = 0; j < item.get(order1 + 1).length; j++) {
			if (user.get(order1 + 1).getMoney() >= item.get(order1 + 1)[j].getPrice()) {
				System.out.println(item.get(order1 + 1)[j]);
			}
		}

		System.out.println("========== 마법사 ==========");
		for (int j = 0; j < item.get(order1 + 2).length; j++) {
			if (user.get(order1 + 2).getMoney() >= item.get(order1 + 2)[j].getPrice()) {
				System.out.println(item.get(order1 + 2)[j]);
			}
		}
	}
}