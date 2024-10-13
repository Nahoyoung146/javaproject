package homework;

import java.util.ArrayList;

public class Npc extends Rpg implements Attack {
	Npc(String name, int atk) {
		super(name, atk);
	}

	public void attack(Monster mon) {
		System.out.println(this.getName() + "이(가) 공격을 합니다.");
		mon.setHp(mon.getHp() - this.getAtk());
		System.out.println("적 체력 : " + mon.getHp());
	}

	public String toString() {
		return "Npc이름 : " + this.getName() + ", 공격력 : " + this.getAtk();
	}
}