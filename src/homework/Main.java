package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void printinfo(String GameName) {
		System.out.print("게임이름 : " + GameName + "\n");
		System.out.print("========== 게임 룰 설명 ==========\n1. 총 3개의 던전을 클리어하는 것이 목적이고"
				+ "한 던전당 일반 몬스터 2마리, 보스 몬스터 1마리가 순차적으로 등장하고 모험가가 선공이고 던전 입장시 Npc와 동행할지 안할지 결정."
				+ "\n2. 모험가는 레벨 1부터 시작하고 몬스터 처치시 경험치, 골드 획득 그리고 10레벨이 되면 전사, 궁수, 마법사로 전직이 가능하고 얻은 골드로 Npc한테 무기 구입 가능.\n"
				+ "3. 총 3명의 모험가 캐릭터가 한 팀으로 진행하고 모혐가 전원 사망이면 게임 종료 그 외에 경우에는 게임이 진행되고 만약에 이전 던전에서 모험가가 죽었으면 다음 던전 입장시 기존의 최대 체력으로 부활함.\n4. 마지막으로 Npc 부가적으로 "
				+ "버프를 줄 수 있고 상대 몬스터의 특수효과가 존재할 수도 있다.\n=================================================================================\n");
	}

	public static void main(String[] args) {
		User[] user = { new Warrior("모험가1", 1000, 100, 10, "전사"), new Archer("모험가2", 800, 200, 50, "궁수"),
				new Magician("모험가3", 500, 300, 80, "마법사") };
		ArrayList<User> Arrayuser = new ArrayList<User>();
		int s1 = 0;
		while (s1 < user.length) {
			Arrayuser.add(user[s1]);
			s1++;
		}
		MonDragon[] dragon = { new DragonFirst("용기병", 1000, 500, "용족", 10), new DragonSecond("비늘용", 200, 20, "용족", 30),
				new DragonThird("데스윙", 300, 30, "용족", 50) };
		MonDemon[] demon = { new DemonFirst("하급악마", 350, 35, "악마족", 70), new DemonSecond("총의악마", 400, 40, "악마족", 90),
				new DemonThird("어둠의 형상", 450, 45, "용족", 120) };
		MonMachine[] machine = { new MachineFirst("안녕로봇", 500, 50, "기계족", 140),
				new MachineSecond("기계거미", 550, 55, "기계족", 160), new MachineThird("기계박사 홍길동", 600, 60, "기계족", 200) };
		ArrayList<Monster[]> mon = new ArrayList<Monster[]>();
		mon.add(dragon);
		mon.add(demon);
		mon.add(machine);
		NpcBattle[] npc = { new BattleHigh("알프레드", 100), new BattleMid("사바나", 50), new BattleLow("조나단", 10) };
		ItemWa[] wa = { new Sword("대검", 1000, 10), new Blade("소검", 2000, 20), new Blunt("둔기", 3000, 30) };
		ItemAr[] ar = { new Cross("석궁", 1500, 10), new Bow("활", 2500, 20) };
		ItemMa[] ma = { new Wand("완드", 1000, 10), new Broom("빗자루", 1500, 20) };
		ArrayList<Item[]> item = new ArrayList<Item[]>();
		item.add(wa);
		item.add(ar);
		item.add(ma);

		Scanner sc = new Scanner(System.in);
		String[] stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		printinfo("전설의 시작");
		boolean[] ClassUp = { true, true, true };
		int turn = 0;
		s1 = 0;
		boolean help = false;
		while (s1 < stage.length) {
			User.initial(Arrayuser, user);
			NpcInfo.buff(Arrayuser);
			NpcItems.iteminfo(item, 0);
			NpcItems.itemcanbuy(item, Arrayuser, 0);
			System.out.println(stage[s1] + "에 입장합니다.");
			int qua = (int) (Math.random() * 3);
			System.out.println("전투Npc의 도움을 받겠습니까?\n단, 무작위로 Npc가 정해집니다. : y/n");
			char answer = sc.next().charAt(0);
			if (answer == 'y') {
				System.out.println(npc[qua]);
				help = true;
			}

			int s2 = 0;
			while (s2 < mon.get(s1).length) {
				int s3 = 0;
				while (s3 < Arrayuser.size()) {
					System.out.println(Arrayuser.get(s3));
					s3++;
				}
				System.out.println("=================================================================================");
				System.out.println(s2 + 1 + "번째 몬스터가 등장했습니다");
				System.out.println(mon.get(s1)[s2]);

				while (true) {
					turn++;
					System.out.println("턴 수 : " + turn);
					s3 = 0;
					while (s3 < Arrayuser.size()) {
						if (ClassUp[s3] == false && Arrayuser.get(s3).getMp() >= 30) {
							System.out.print("공격방식을 선택하세요. 1.일반공격 2.스킬 : ");
							int num = sc.nextInt();
							if (num == 1)
								Arrayuser.get(s3).attack(Arrayuser, mon, s3, s1, s2);
							else
								Arrayuser.get(s3).Skill(Arrayuser, mon, s1, s2);
						}

						else
							Arrayuser.get(s3).attack(Arrayuser, mon, s3, s1, s2);
						s3++;
					}

					s3 = 0;

					if (help)
						npc[qua].attack(Arrayuser, mon, s1, s2, 0);

					if (Rpg.deathmonster(mon, s1, s2)) {
						System.out.println("적이 쓰려졌습니다.");
						while (s3 < Arrayuser.size()) {
							Arrayuser.get(s3).Expup(mon.get(s1)[s2]); 
							Arrayuser.get(s3).MoneyUp(mon.get(s1)[s2]); //Mon.get(order)[order2]
							if (Arrayuser.get(s3).getLevel() >= 10 && ClassUp[s3]) {
								System.out.println("축하합니다." + Arrayuser.get(s3).getName() + "이(가) 레벨10을 달성해서 "
										+ Arrayuser.get(s3).getFuturejob() + "으로 전직하였습니다. 이제부터 직업스킬이 사용가능합니다.");
								ClassUp[s3] = false;
								Arrayuser.get(s3).setJob(Arrayuser.get(s3).getFuturejob());
							}
							s3++;
						}
						turn = 0;
						break;
					}

					if (s2 == 2) {
						int boss = (int) (Math.random() * 3);
						if (boss == 0)
							mon.get(s1)[s2].Skill(Arrayuser, mon, 0, 0);

						else
							dragon[s2].attack(Arrayuser, mon, s1, s2, 0);
					}

					else {
						dragon[s2].attack(Arrayuser, mon, s1, s2, 0);
					}

					s3 = 0;
					while (s3 < Arrayuser.size()) {
						if (Arrayuser.get(s3).getHp() <= 0) {
							Arrayuser.remove(s3);
							System.err.println(Arrayuser);
						}
						s3++;
					}

					if (Rpg.deathuser(Arrayuser)) {
						System.out.println("모험가가 모두 사망해서 게임이 종료됩니다");
						break;
					}

					System.out.println("모험가들의 일정량의 hp와 mp가 회복되었습니다.");
					s3 = 0;
					while (s3 < Arrayuser.size()) {
						Arrayuser.get(s3).recovery();
						s3++;
					}
					System.out.println("=============================================");
				}
				if (Rpg.deathuser(Arrayuser))
					break;
				s2++;
			}
			if (Rpg.deathuser(Arrayuser))
				break;

			if (s1 == 2) {
				System.out.println("모든 스테이지를 클리어하셨습니다.\n축하합니다.");
				break;
			}
			s1++;
		}
	}
}