package homework;

import java.util.ArrayList;

public class Rpg {
	private String name;
	private int hp, mp, atk;

	Rpg() {
		this.name = "가나다";
		this.hp = 0;
		this.mp = 0;
		this.atk = 0;
	}

	Rpg(String name) {
		this.name = name;
		this.hp = 1000;
		this.mp = 100;
		this.atk = 10;
	}

	Rpg(String name, int atk) {
		this.name = name;
		this.hp = 1000;
		this.mp = 100;
		this.atk = atk;
	}

	Rpg(String name, int hp, int atk) {
		this.name = name;
		this.hp = hp;
		this.mp = 0;
		this.atk = atk;
	}

	public String getName() {
		return name;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getMp() {
		return mp;
	}

	public void setMp(int mp) {
		this.mp = mp;
	}

	public int getAtk() {
		return atk;
	}

	public void setAtk(int atk) {
		this.atk = atk;
	}

	public static void printinfo(String GameName) {
		System.out.print("게임이름 : " + GameName + "\n");
		System.out.print("========== 게임 룰 설명 ==========\n1. 총 3개의 던전을 클리어하는 것이 목적이고"
				+ "한 던전당 일반 몬스터 2마리, 보스 몬스터 1마리가 순차적으로 등장하고 모험가가 선공이고 던전 입장시 Npc와 동행할지 안할지 결정."
				+ "\n2. 모험가는 레벨 1부터 시작하고 몬스터 처치시 경험치, 골드 획득 그리고 10레벨이 되면 전사, 궁수, 마법사로 전직이 가능하고 얻은 골드로 Npc한테 무기 구입 가능.\n"
				+ "3. 총 3명의 모험가 캐릭터가 한 팀으로 진행하고 모혐가 전원 사망이면 게임 종료 그 외에 경우에는 게임이 진행되고 만약에 이전 던전에서 모험가가 죽었으면 다음 던전 입장시 기존의 최대 체력으로 부활함.\n4. 마지막으로 Npc 부가적으로 "
				+ "버프를 줄 수 있고 상대 몬스터의 특수효과가 존재할 수도 있다.\n=================================================================================\n");
	}

	public static boolean deathuser(ArrayList<User> user) {
		int sum = 0;
		int i = 0;
		while (i < user.size()) {
			sum += user.get(i).getHp();
			i++;
		}

		if (sum <= 0)
			return true;

		return false;
	}

	public static boolean deathmonster(ArrayList<Monster[]> Mon, int order, int order2) {
		while (order2 < Mon.get(order).length) {
			if (Mon.get(order)[order2].getHp() <= 0)
				return true;
			order2++;
		}

		return false;
	}
}