package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
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
		int i = 0;
		while (i < user.length) {
			sum += user[i].getHp();
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

	public static void iteminfo(ArrayList<Item[]> item, String[] job) {
		System.out.println("아이템Npc가 등장했습니다");
		int i = 0;
		while (i < item.size()) {
			System.out.println("==================" + job[i] + "==================");
			for (int j = 0; j < item.get(i).length; j++) {
				System.out.println(item.get(i)[j]);

			}
			i++;
		}
	}

	public static void itemcanbuy(ArrayList<Item[]> item, User[] user, String[] job, int[] check) {
		System.out.println("구매 가능 물품\n금액 부족시 아무 아이템도 보이지 않음\n무기 구매는 캐릭터당 한번만 구매가능하며 무기교체는 불가능");
		int i = 0;
		while (i < item.size()) {
			System.out.println("==================" + job[i] + "==================");
			for (int j = 0; j < item.get(i).length; j++) {
				if (user[i].getMoney() >= item.get(i)[j].getPrice()) {
					System.out.println(item.get(i)[j]);
					check[i]++;
				}
			}
			i++;
		}
	}

	public static int[] userbuyitem(User[] user, ArrayList<Item[]> item, int[] choice, boolean[] have, int[] check) {
		int i = 0;
		while (i < user.length) {
			if (have[i] == true) {
				System.out.println(user[i].getName() + "는(은) 이미 무기를 가지고 있습니다.");
			}

			else if (check[i] == 0) {
				System.out.println("돈 부족");
			}

			if (i == 0 && !(choice[i] == 1 || choice[i] == 2 || choice[i] == 3) && check[i] != 0) {
				System.out.print("전사 아이템 구매 번호 입력, 0번 입력시 다음 단계로 진행 : ");
				choice[i] = sc.nextInt();
				if (choice[i] == 0) {
					System.out.println("다음 단계 진행");
					have[i] = false;
				}

				else {
					System.out.println(user[i].getName() + "이(가) " + item.get(i)[choice[i] - 1].getName()
							+ "을(를) 구매했습니다.\n이제부터 무기전용 스킬이 사용가능합니다");
					user[i].setMaxatk(user[i].getMaxatk() + item.get(i)[choice[i] - 1].getWeaponatk());
					user[i].setAtk(user[i].getMaxatk());
					user[i].setMoney(user[i].getMoney() - item.get(i)[choice[i] - 1].getPrice());
					have[i] = true;
				}
			}

			else if (i == 1 && !(choice[i] == 1 || choice[i] == 2) && check[i] != 0) {
				System.out.print("궁수 아이템 구매 번호 입력, 0번 입력시 다음 단계로 진행 : ");
				choice[i] = sc.nextInt();
				if (choice[i] == 0) {
					System.out.println("다음 단계 진행");
					have[i] = false;
				}

				else {
					System.out.println(user[i].getName() + "이(가) " + item.get(i)[choice[i] - 1].getName()
							+ "을(를) 구매했습니다.\n이제부터 무기전용 스킬이 사용가능합니다");
					user[i].setMaxatk(user[i].getMaxatk() + item.get(i)[choice[i] - 1].getWeaponatk());
					user[i].setAtk(user[i].getMaxatk());
					user[i].setMoney(user[i].getMoney() - item.get(i)[choice[i] - 1].getPrice());
					have[i] = true;
				}
			}

			else if (i == 2 && !(choice[i] == 1 || choice[i] == 2) && check[i] != 0) {
				System.out.print("마법사 아이템 구매 번호 입력, 0번 입력시 다음 단계로 진행 : ");
				choice[i] = sc.nextInt();
				if (choice[i] == 0) {
					System.out.println("다음 단계 진행");
					have[i] = false;
				}

				else {
					System.out.println(user[i].getName() + "이(가) " + item.get(i)[choice[i] - 1].getName()
							+ "을(를) 구매했습니다.\n이제부터 무기전용 스킬이 사용가능합니다");
					user[i].setMaxatk(user[i].getMaxatk() + item.get(i)[choice[i] - 1].getWeaponatk());
					user[i].setAtk(user[i].getMaxatk());
					user[i].setMoney(user[i].getMoney() - item.get(i)[choice[i] - 1].getPrice());
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

	public static boolean end(User[] user, int s1) {
		if (deathuser(user))
			return true;

		else if (GameClear(s1))
			return true;

		return false;
	}

	public static int intro(ArrayList<Item[]> item, String[] job, User[] user, int[] check, int[] choice,
			boolean[] have, String[] stage, int s1, Npc[] npc, boolean help) {
		iteminfo(item, job);
		itemcanbuy(item, user, job, check);
		userbuyitem(user, item, choice, have, check);
		buff(user);
		System.out.println(stage[s1] + "에 입장합니다.");
		int qua = (int) (Math.random() * 3);
		return qua;
	}

	public static boolean npc(Npc npc, boolean help, ArrayList<Item[]> item, String[] job, User[] user, int[] check,
			int[] choice, boolean[] have, String[] stage, int s1) {
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

		else if (num[1] == 1) {
			ar.Cross(mon.get(s1)[s2], turn);
		}

		else if (num[1] == 2) {
			ar.Bow(mon.get(s1)[s2]);
		}

		else if (num[2] == 1) {
			ma.Wand(mon.get(s1)[s2]);
		}

		else if (num[2] == 2) {
			ma.Broom(mon.get(s1)[s2]);
		}
	}

	public static void main(String[] args) {
		Warrior war = new Warrior("모험가1", 1000, 100, 10);
		Archer arc = new Archer("모험가2", 800, 200, 50);
		Magician mag = new Magician("모험가3", 500, 300, 80);
		User[] user = { war, arc, mag };
		MonDragon[] dragon = { new DragonNormal("용기병", 1000, 10, "용족", 10), new DragonNormal("비늘용", 200, 20, "용족", 30),
				new DragonBoss("데스윙", 300, 30, "용족", 50) };
		MonDemon[] demon = { new DemonNormal("하급악마", 350, 35, "악마족", 70), new DemonNormal("총의악마", 400, 40, "악마족", 90),
				new DemonBoss("어둠의 형상", 450, 45, "용족", 120) };
		MonMachine[] machine = { new MachineNormal("안녕로봇", 500, 50, "기계족", 140),
				new MachineNormal("기계거미", 550, 55, "기계족", 160), new MachineBoss("기계박사 홍길동", 600, 60, "기계족", 200) };
		ArrayList<Monster[]> mon = new ArrayList<Monster[]>();
		mon.add(dragon);
		mon.add(demon);
		mon.add(machine);
		Npc[] npc = { new Npc("알프레드", 100), new Npc("사바나", 50), new Npc("조나단", 10) };
		ItemWa[] wa = { new ItemWa("대검", 1000, 10), new ItemWa("소검", 2000, 20), new ItemWa("둔기", 3000, 30) };
		ItemAr[] ar = { new ItemAr("석궁", 1500, 10), new ItemAr("활", 2500, 20) };
		ItemMa[] ma = { new ItemMa("완드", 1000, 10), new ItemMa("빗자루", 1500, 20) };
		ArrayList<Item[]> item = new ArrayList<Item[]>();
		item.add(wa);
		item.add(ar);
		item.add(ma);
		boolean[] have = new boolean[3];
		int[] check = new int[3];
		int[] choice = new int[3];
		String[] job = { "전사", "궁수", "마법사" };
		String[] stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		boolean[] ClassUp = { true, true, true };
		int turn = 0;
		int s1 = 0;
		boolean help = false;
		printinfo("전설의 시작");
//		user[0].setMoney(10000);
//		user[1].setMoney(10000);
//		user[2].setMoney(10000);
		while (s1 < stage.length) {
			int intro = intro(item, job, user, check, choice, have, stage, s1, npc, help);
			boolean npc0 = npc(npc[intro], help, item, job, user, check, choice, have, stage, s1);
			int s2 = 0;
			while (s2 < mon.get(s1).length) {
				info(user, mon, s1, s2);
				while (true) {
					turn++;
					System.out.println("턴 수 : " + turn);
					int s3 = 0;
					/*while (s3 < user.length) {
						if (user[s3].getHp() <= 0) {
							s3++;
							continue;
						}

						int[] buynum = userbuyitem(user, item, choice, have, check);
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
					}*/ //함수화 해야함

					if (npc0)
						npc[intro].attack(mon.get(s1)[s2]);

					if (deathmonster(mon, s1, s2)) {
						s3 = 0;
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
						break;
					}

					if (s2 == 2) {
						int boss = (int) (Math.random() * 3);
						if (boss == 0)
							mon.get(s1)[s2].Skill1(user);

						else
							mon.get(s1)[s2].attack1(user);
					}

					else {
						mon.get(s1)[s2].attack1(user);
					}

					if (deathuser(user)) {
						System.out.println("모험가가 모두 사망해서 게임이 종료됩니다");
						break;
					}

					s3 = 0;
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
				if (deathuser(user))
					break;
				s2++;
			}

			if (end(user, s1))
				break;

			initial(user);
			s1++;
		}
	}
}