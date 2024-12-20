package homework;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
	static Scanner sc = new Scanner(System.in);

	public static void printinfo(String GameName) {
		System.out.print("게임이름 : " + GameName + "\n");
		System.out.print("========== 게임 룰 설명 ==========\n1. 총 3개의 던전을 클리어하는 것이 목적이고"
				+ "한 던전당 일반 몬스터 2마리, 보스 몬스터 1마리가 순차적으로 등장하고 모험가가 선공이고 던전 입장시 Npc와 동행할지 안할지 결정."
				+ "\n2. 모험가는 레벨 1부터 시작하고 몬스터 처치시 경험치, 골드 획득 그리고 10레벨이 되면 전사, 궁수, 마법사로 전직이 가능하고 얻은 골드로 Npc한테 무기 구입 가능.\n"
				+ "3. 총 3명의 모험가 캐릭터가 한 팀으로 진행하고 모혐가 전원 사망이면 게임 종료 그 외에 경우에는 게임이 진행되고 만약에 이전 던전에서 모험가가 죽었으면 다음 던전 입장시 기존의 최대 체력으로 부활함.\n4. 마지막으로 Npc 부가적으로 "
				+ "버프를 줄 수 있고 상대 몬스터의 특수효과가 존재할 수도 있다.\n=================================================================================\n");
	}

	public static boolean deathuser(User[] user) {
		int sum = 0;
		for (int i = 0; i < user.length; i++) {
			sum += user[i].getHp();
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

	public static void initial(User[] user) {
		int i = 0;
		while (i < user.length) {
			user[i].setHp(user[i].getMaxhp());
			user[i].setMp(user[i].getMaxmp());
			user[i].setAtk(user[i].getMaxatk());
			i++;
		}
	}

	public static void buff(User[] user) {
		System.out.println("길잡이npc가 등장했습니다.\n일정확률로 버프가 적용됩니다.");
		int a = (int) (Math.random() * 3) + 1;
		switch (a) {
		case 1:
			System.out.println("모험가들 공격력 증가");
			int i = 0;
			while (i < user.length) {
				user[i].setAtk(user[i].getAtk() + 50);
				i++;
			}
			break;
		case 2:
			System.out.println("모험가들 Hp과(와) Mp 증가");
			i = 0;
			while (i < user.length) {
				user[i].setHp(user[i].getMaxhp() + 100);
				user[i].setMp(user[i].getMaxmp() + 50);
				i++;
			}
			break;
		default:
			System.out.println("아쉽지만 아무 버프도 받지 못했습니다.");
		}
	}

	public static void iteminfo(Item[][] item, String[] job, User[] user, int[] check) {
		System.out.println("아이템Npc가 등장했습니다");
		int i = 0;
		while (i < item.length) {
			System.out.println("==================" + job[i] + "==================");
			for (int j = 0; j < item[i].length; j++)
				System.out.println(item[i][j]);
			i++;
		}

		System.out.println("구매 가능 물품\n금액 부족시 아무 아이템도 보이지 않음\n무기 구매는 캐릭터당 한번만 구매가능하며 무기교체는 불가능");
		i = 0;
		while (i < item.length) {
			System.out.println("==================" + job[i] + "==================");
			for (int j = 0; j < item[i].length; j++) {
				if (user[i].getMoney() >= item[i][j].getPrice()) {
					System.out.println(item[i][j]);
					check[i]++;
				}
			}
			i++;
		}
	}

	public static int[] userbuyitem(User[] user, Item[][] item, int[] choice, boolean[] have, int[] check) {
		int i = 0;
		while (i < user.length) {
			if (have[i] == true) {
				System.out.println(user[i].getName() + "는(은) 이미 무기를 가지고 있습니다.");
				i++;
				continue;
			}

			if (check[i] == 0) {
				System.out.println("돈 부족");
				i++;
				continue;
			}

			if (have[i] == false && check[i] != 0) {
				System.out.print(user[i].getName() + "님 아이템 구매 번호 입력, 0번 입력시 다음 단계로 진행 : ");
				choice[i] = sc.nextInt();
				if (choice[i] == 0) {
					System.out.println("다음 단계 진행");
				}

				else {
					System.out.println(user[i].getName() + "이(가) " + item[i][choice[i] - 1].getName()
							+ "을(를) 구매했습니다.\n이제부터 무기전용 스킬이 사용가능합니다");
					user[i].setMaxatk(user[i].getMaxatk() + item[i][choice[i] - 1].getWeaponatk());
					user[i].setAtk(user[i].getMaxatk());
					user[i].setMoney(user[i].getMoney() - item[i][choice[i] - 1].getPrice());
					have[i] = true;
				}
			}
			i++;
		}
		return choice;
	}

	public static boolean GameClear(int s1) {
		if (s1 == 2) {
			System.out.println("모든 스테이지를 클리어하셨습니다.\n축하합니다.");
			return true;
		}
		return false;
	}

	public static int[] item0(Item[][] item, String[] job, User[] user, int[] check, int[] choice, boolean[] have) {
		iteminfo(item, job, user, check);
		int[] buynum = userbuyitem(user, item, choice, have, check);
		return buynum;
	}

	public static int intro(User[] user, String[] stage, int s1) {
		buff(user);
		System.out.println(stage[s1] + "에 입장합니다.");
		int qua = (int) (Math.random() * 3);
		return qua;
	}

	public static boolean npc(Npc npc, boolean help) {
		System.out.println("전투Npc의 도움을 받겠습니까?\n단, 무작위로 Npc가 정해집니다. : y/n");
		char answer = sc.next().charAt(0);
		if (answer == 'y') {
			System.out.println(npc);
			help = true;
			return help;
		}
		return help;
	}

	public static void info(User[] user, ArrayList<Monster[]> mon, int s1, int s2) {
		int s3 = 0;
		while (s3 < user.length) {
			System.out.println(user[s3]);
			s3++;
		}
		System.out.println("=================================================================================");
		System.out.println(s2 + 1 + "번째 몬스터가 등장했습니다");
		System.out.println(mon.get(s1)[s2]);
	}

	public static void weapon(Warrior wa, Archer ar, Magician ma, ArrayList<Monster[]> mon, int s1, int s2, int turn,
			int[] num) {
		if (num[0] == 1) {
			wa.Sword(mon.get(s1)[s2]);
		}

		else if (num[0] == 2) {
			wa.Blade(mon.get(s1)[s2]);
		}

		else if (num[0] == 2) {
			wa.Blade(mon.get(s1)[s2]);
		}

		if (num[1] == 1) {
			ar.Cross(mon.get(s1)[s2], turn);
		}

		else if (num[1] == 2) {
			ar.Bow(mon.get(s1)[s2]);
		}

		if (num[2] == 1) {
			ma.Wand(mon.get(s1)[s2]);
		}

		else if (num[2] == 2) {
			ma.Broom(mon.get(s1)[s2]);
		}
	}

	public static void userattack(User[] user, boolean[] ClassUp, ArrayList<Monster[]> mon, int s1, int s2, Warrior war,
			Archer arc, Magician mag, int turn, boolean npc0, Npc[] npc, int intro, int[] buynum) {
		int s3 = 0;
		while (s3 < user.length) {
			if (user[s3].getHp() <= 0) {
				s3++;
				continue;
			}

			if (user[s3].getMp() >= 50) {
				if (ClassUp[s3] == false && buynum[s3] != 0) {
					System.out.print("공격방식을 선택하세요/1. 일반공격 2. 스킬 3. 무기스킬 : ");
					int num = sc.nextInt();
					if (num == 1)
						user[s3].attack(mon.get(s1)[s2]);

					else if (num == 2)
						user[s3].Skill(user, mon.get(s1)[s2]);

					else
						weapon(war, arc, mag, mon, s1, s2, turn, buynum);
				}

				else if (ClassUp[s3] == false && buynum[s3] == 0) {
					System.out.print("공격방식을 선택하세요/1. 일반공격 2. 스킬 : ");
					int num = sc.nextInt();
					if (num == 1)
						user[s3].attack(mon.get(s1)[s2]);

					else
						user[s3].Skill(user, mon.get(s1)[s2]);
				}

				else if (ClassUp[s3] == true && buynum[s3] != 0) {
					System.out.print("공격방식을 선택하세요/1. 일반공격 2. 무기스킬 : ");
					int num = sc.nextInt();
					if (num == 1)
						user[s3].attack(mon.get(s1)[s2]);

					else
						weapon(war, arc, mag, mon, s1, s2, turn, buynum);
				}

				else
					user[s3].attack(mon.get(s1)[s2]);
			}

			else if (user[s3].getMp() >= 30) {
				if (ClassUp[s3] == false) {
					System.out.print("공격방식을 선택하세요/1. 일반공격 2. 스킬 : ");
					int num = sc.nextInt();
					if (num == 1)
						user[s3].attack(mon.get(s1)[s2]);

					else
						user[s3].Skill(user, mon.get(s1)[s2]);
				}

				else
					user[s3].attack(mon.get(s1)[s2]);
			}

			else
				user[s3].attack(mon.get(s1)[s2]);
			s3++;
		}

		if (npc0)
			npc[intro].attack(mon.get(s1)[s2]);
	}

	public static boolean userattackafter(User[] user, ArrayList<Monster[]> mon, int s1, int s2, boolean[] ClassUp,
			String[] job, int turn) {
		if (deathmonster(mon, s1, s2)) {
			int s3 = 0;
			System.out.println("적이 쓰려졌습니다.");
			while (s3 < user.length) {
				if (user[s3].getHp() <= 0) {
					s3++;
					continue;
				}

				else {
					user[s3].Expup(mon.get(s1)[s2]);
					user[s3].MoneyUp(mon.get(s1)[s2]);
					if (user[s3].getLevel() >= 10 && ClassUp[s3]) {
						System.out.println("축하합니다." + user[s3].getName() + "이(가) 레벨10을 달성해서 " + job[s3]
								+ "으로 전직하였습니다. 이제부터 직업스킬이 사용가능합니다.");
						ClassUp[s3] = false;
						user[s3].setJob(job[s3]);
					}
					s3++;
				}

			}
			turn = 0;
			return true;
		}

		return false;
	}

	public static void monsterattack(int s2, ArrayList<Monster[]> mon, User[] user, int s1) {
		if (s2 == 2) {
			int boss = (int) (Math.random() * 3);
			if (boss == 0)
				mon.get(s1)[s2].Skillmon(user);

			else
				mon.get(s1)[s2].attackmon(user);
		}

		else {
			mon.get(s1)[s2].attackmon(user);
		}
	}

	public static void recovery(User[] user) {
		int s3 = 0;
		while (s3 < user.length) {
			if (user[s3].getHp() <= 0) {
				s3++;
				continue;
			} else {
				user[s3].recovery();
				s3++;
			}
		}
		System.out.println("모험가들의 일정량의 hp와 mp가 회복되었습니다.");
		System.out.println("=============================================");
	}

	public static boolean intermediate(User[] user, boolean[] ClassUp, ArrayList<Monster[]> mon, int s1, int s2,
			Warrior war, Archer arc, Magician mag, boolean npc0, Npc[] npc, int intro, int[] buynum, String[] job) {
		int turn = 0;
		while (true) {
			turn++;
			System.out.println("턴 수 : " + turn);

			userattack(user, ClassUp, mon, s1, s2, war, arc, mag, turn, npc0, npc, intro, buynum);

			if (userattackafter(user, mon, s1, s2, ClassUp, job, turn)) {
				break;
			}

			monsterattack(s2, mon, user, s1);

			if (deathuser(user)) {
				System.out.println("모험가가 모두 사망해서 게임이 종료됩니다");
				return true;
			}

			recovery(user);
		}

		return false;
	}

	public static boolean finale(int s1, User[] user) {
		if (GameClear(s1))
			return true;

		initial(user);

		return false;
	}

	public static void main(String[] args) {
		Warrior war = new Warrior("모험가1", 1000, 100, 50);
		Archer arc = new Archer("모험가2", 800, 200, 80);
		Magician mag = new Magician("모험가3", 500, 300, 100);
		User[] user = { war, arc, mag };
		MonDragon[] dragon = { new DragonNormal("용기병", 1000, 10, "용족", 10), new DragonNormal("비늘용", 2000, 20, "용족", 30),
				new DragonBoss("데스윙", 3000, 30, "용족", 50) };
		MonDemon[] demon = { new DemonNormal("하급악마", 3500, 35, "악마족", 70), new DemonNormal("총의악마", 4000, 40, "악마족", 90),
				new DemonBoss("어둠의 형상", 4500, 45, "용족", 120) };
		MonMachine[] machine = { new MachineNormal("안녕로봇", 5000, 50, "기계족", 140),
				new MachineNormal("기계거미", 5500, 55, "기계족", 160), new MachineBoss("기계박사 홍길동", 6000, 60, "기계족", 200) };
		ArrayList<Monster[]> mon = new ArrayList<Monster[]>();
		mon.add(dragon);
		mon.add(demon);
		mon.add(machine);
		Npc[] npc = { new Npc("알프레드", 100), new Npc("사바나", 50), new Npc("조나단", 10) };
		Item[][] item = { { new Item("대검", 1000, 10), new Item("소검", 2000, 20), new Item("둔기", 3000, 30) },
				{ new Item("석궁", 1500, 10), new Item("활", 2500, 20) },
				{ new Item("완드", 1000, 10), new Item("빗자루", 1500, 20) } };
		boolean[] have = new boolean[3], ClassUp = { true, true, true };
		int[] check = new int[3], choice = new int[3];
		String[] job = { "전사", "궁수", "마법사" }, stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		int s1 = 0;
		boolean help = false;
		printinfo("전설의 시작");
//		user[0].setLevel(10);
//		user[1].setLevel(10);
//		user[2].setLevel(10);
//		user[0].setMoney(10000);
//		user[1].setMoney(10000);
//		user[2].setMoney(10000);
		while (s1 < stage.length) {
			int[] buynum = item0(item, job, user, check, choice, have);
			int intro = intro(user, stage, s1);
			boolean npc0 = npc(npc[intro], help);
			int s2 = 0;
			while (s2 < mon.get(s1).length) {
				info(user, mon, s1, s2);
				if (intermediate(user, ClassUp, mon, s1, s2, war, arc, mag, npc0, npc, intro, buynum, job))
					return;
				s2++;
			}

			if (finale(s1, user))
				return;
			s1++;
		}
	}
}