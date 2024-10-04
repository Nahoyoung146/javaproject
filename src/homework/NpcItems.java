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
		for (int i = 0; i < item.get(order+1).length; i++) {
			System.out.println(item.get(order+1)[i]);
		}

		System.out.println("========== 마법사 ==========");
		for (int i = 0; i < item.get(order+2).length; i++) {
			System.out.println(item.get(order+2)[i]);
		}
	}
}