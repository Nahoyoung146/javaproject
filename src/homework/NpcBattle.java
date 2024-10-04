package homework;

import java.util.ArrayList;

public class NpcBattle extends Npc implements Attack {
	NpcBattle() {
		super();
	}

	NpcBattle(String name, int atk) {
		super(name, atk);
	}

	public void attack(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2, int order3) {
		System.out.println(this.getName() + "이(가) 공격을 합니다.");
		Mon.get(order)[order2].setHp(Mon.get(order)[order2].getHp() - this.getAtk());
		System.out.println("적 체력 : " + Mon.get(order)[order2].getHp());
	}

	public String toString() {
		return "Npc이름 : " + this.getName() + ", 공격력 : " + this.getAtk();
	}
}