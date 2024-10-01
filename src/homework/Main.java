package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
//		User[] user = { new Warrior("모험가1", "모험가", "전사"), new Archer("모험가2", "모험가", "궁수"),
//				new Magician("모험가3", "모험가", "마법사") };
		ArrayList<User> user = new ArrayList<User>();
		user.add(new Warrior("모험가1", "모험가", "전사"));
		user.add(new Archer("모험가2", "모험가", "궁수"));
		user.add(new Magician("모험가3", "모험가", "마법사"));

		MonDragon[] dragon = { new DragonFirst("용기병", 1000, 10, "용족", 1), new DragonSecond("비늘용", 2000, 20, "용족", 3),
				new DragonThird("데스윙", 3000, 30, "용족", 5) };
		MonDemon[] demon = { new DemonFirst("하급악마", 3500, 35, "악마족", 7), new DemonSecond("총의악마", 4000, 40, "악마족", 9),
				new DemonThird("어둠의 형상", 4500, 45, "용족", 12) };
		MonMachine[] machine = { new MachineFirst("안녕로봇", 5000, 50, "기계족", 14),
				new MachineSecond("기계거미", 5500, 55, "기계족", 16), new MachineThird("기계박사 홍길동", 6000, 60, "기계족", 20) };
		ArrayList<Object> mon = new ArrayList<Object>();
		mon.add(dragon);
		mon.add(demon);
		mon.add(machine);

		NpcBattle[] npc = { new BattleHigh("알프레드", 100), new BattleMid("사바나", 50), new BattleLow("조나단", 10) };
		Scanner sc = new Scanner(System.in);
		String[] stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		Rpg.printinfo("전설의 시작");
		boolean[] ClassUp = { true, true, true };
		int turn = 0;
		int s2 = 0;
		boolean help = false;
		while (s2 < stage.length) {
			System.out.println(stage[s2] + "에 입장합니다.");
			int qua = (int) (Math.random() * 3);
			System.out.println("전투Npc의 도움을 받겠습니까?\n단, 무작위로 Npc가 정해집니다. : y/n");
			char answer = sc.next().charAt(0);
			if (answer == 'y') {
				System.out.println(npc[qua]);
				help = true;
			}

			int s3 = 0;
			while (s3 < 3) {
				int s1 = 0;
				while (s1 < user.size()) {
					System.out.println(user.get(s1));
					s1++;
				}
				System.out.println("=================================================================================");
				System.out.println(s3 + 1 + "번째 몬스터가 등장했습니다");
				System.out.println(mon.get(s2));// dragon[s3];
//				int[] list= new int[3];
//				System.out.println(list[0]);

				while (true) {
					turn++;
					System.out.println("턴 수 : " + turn);
					int s4 = 0;
					while (s4 < user.size()) {
						if (ClassUp[s4] == false) {
							System.out.print("공격방식을 선택하세요. 1.일반공격 2.스킬 : ");
							int num = sc.nextInt();
							if (num == 1)
								user.get(s4).attack(user, dragon, s3, s4);
							else
								user.get(s4).Skill(user, dragon, s3);
						}

						else
							user.get(s4).attack(user, dragon, s3, s4);
						s4++;
					}

					s4 = 0;

					if (help)
						npc[qua].attack(user, dragon, s3, s4);

					if (Rpg.death(user, dragon, demon, machine, s3)) {
						System.out.println("적이 쓰려졌습니다.");
						while (s4 < user.size()) {
							user.get(s4).Expup(dragon[s3]);
							user.get(s4).MoneyUp(dragon[s3]);
							if (user.get(s4).getLevel() >= 10 && ClassUp[s4]) {
								System.out.println("축하합니다." + user.get(s4).getName() + "이(가) 레벨10을 달성해서 "
										+ user.get(s4).getFuturejob() + "으로 전직하였습니다. 이제부터 직업스킬이 사용가능합니다.");
								ClassUp[s4] = false;
								user.get(s4).setJob(user.get(s4).getFuturejob());
							}
							s4++;
						}
						turn = 0;
						break;
					}

					if (s3 == 2) {
						int boss = (int) (Math.random() * 3);
						if (boss == 0)
							dragon[s3].Skill(user, dragon, s3);

						else
							dragon[s3].attack(user, dragon, s3, s4);
					}

					else {
						dragon[s3].attack(user, dragon, s3, s4);
					}

					s4 = 0;
					while (s4 < user.size()) {
						if (user.get(s4).getHp() <= 0) {
							user.remove(s4);
						}
						s4++;
					}

					if (Rpg.death(user, dragon, demon, machine, s3)) {
						System.out.println("모험가가 모두 사망해서 게임이 종료됩니다");
						break;
					}

					System.out.println("모험가들의 일정량의 hp와 mp가 회복되었습니다.");
					s4 = 0;
					while (s4 < user.size()) {
						user.get(s4).recovery();
						s4++;
					}
					System.out.println("=============================================");
				}
				s3++;
			}
		}
		s2++;
	}
}