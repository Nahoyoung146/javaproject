package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		User[] user = { new Warrior("모험가1", "전사"), new Archer("모험가2", "궁수"), new Magician("모험가3", "마법사") };
		ArrayList<User> Arrayuser = new ArrayList<User>();
		int s1 = 0;
		while (s1 < user.length) {
			Arrayuser.add(user[s1]);
			s1++;
		}
		MonDragon[] dragon = { new DragonFirst("용기병", 1000, 10, "용족", 10), new DragonSecond("비늘용", 2000, 20, "용족", 30),
				new DragonThird("데스윙", 3000, 30, "용족", 50) };
		MonDemon[] demon = { new DemonFirst("하급악마", 3500, 35, "악마족", 70), new DemonSecond("총의악마", 4000, 40, "악마족", 90),
				new DemonThird("어둠의 형상", 4500, 45, "용족", 120) };
		MonMachine[] machine = { new MachineFirst("안녕로봇", 5000, 50, "기계족", 140),
				new MachineSecond("기계거미", 5500, 55, "기계족", 160), new MachineThird("기계박사 홍길동", 6000, 60, "기계족", 200) };
		ArrayList<Monster[]> mon = new ArrayList<Monster[]>();
		mon.add(dragon);
		mon.add(demon);
		mon.add(machine);
		NpcBattle[] npc = { new BattleHigh("알프레드", 100), new BattleMid("사바나", 50), new BattleLow("조나단", 10) };
		ItemWa[] wa = { new Sword("대검", 1000, 10, true), new Blade("소검", 2000, 20, true),
				new Blunt("둔기", 3000, 30, true) };
		ItemAr[] ar = { new Cross("석궁", 1500, 10, true), new Bow("활", 2500, 20, true) };
		ItemMa[] ma = { new Wand("완드", 1000, 10, true), new Broom("빗자루", 1500, 20, true) };
		ArrayList<Item[]> item = new ArrayList<Item[]>();
		item.add(wa);
		item.add(ar);
		item.add(ma);

		Scanner sc = new Scanner(System.in);
		String[] stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		Rpg.printinfo("전설의 시작");
		boolean[] ClassUp = { true, true, true };
		int turn = 0;
		s1 = 0;
		boolean help = false;
		while (s1 < stage.length) {
			NpcInfo.buff(Arrayuser);
			User.initial(Arrayuser, user);
			NpcItems.iteminfo(item, 0);
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
						if (ClassUp[s3] == false) {
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

					if (Rpg.death(Arrayuser, mon, s1, s2)) {
						System.out.println("적이 쓰려졌습니다.");
						while (s3 < Arrayuser.size()) {
							Arrayuser.get(s3).Expup(mon, s1, s2);
							Arrayuser.get(s3).MoneyUp(mon, s1, s2);
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
						}
						s3++;
					}

					if (Rpg.death(Arrayuser, mon, s1, s2)) {
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
				s2++;
			}
			User.buffinitial(Arrayuser, user, NpcInfo.buff(Arrayuser));
		}
		s1++;
	}
}