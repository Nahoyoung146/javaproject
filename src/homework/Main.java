package homework;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		User[] user = { new Warrior("모험가1", "모험가"), new Archer("모험가2", "모험가"), new Magician("모험가3", "모험가") };
		MonDragon[] dragon = { new DragonFirst("용기병", 1000, 10, "용족", 1), new DragonSecond("비늘용", 2000, 20, "용족", 3),
				new DragonThird("데스윙", 3000, 30, "용족", 5) };
		MonDemon[] demon = { new DemonFirst("하급악마", 3500, 35, "악마족", 7), new DemonSecond("총의악마", 4000, 40, "악마족", 9),
				new DemonThird("어둠의 형상", 4500, 45, "용족", 12) };
		MonMachine[] machine = { new MachineFirst("안녕로봇", 5000, 50, "기계족", 14),
				new MachineSecond("기계거미", 5500, 55, "기계족", 16), new MachineThird("기계박사 홍길동", 6000, 60, "기계족", 20) };
	
		NpcBattle[] npc = { new BattleHigh("알프레드", 100), new BattleMid("사바나", 50), new BattleLow("조나단", 10) };
		Scanner sc = new Scanner(System.in);
		String[] stage = { "용들의 무덤", "어둠의 동물원", "기계성" };
		int[] order = { 0, 1, 2 };

		Rpg.printinfo("전설의 시작");
		int a = 0;
		while (a < user.length) {
			System.out.println(user[a]);
			a++;
		}
		System.out.println("=================================================================================");
		int turn = 1;
		int i = 0;
		while (i < stage.length) {
			System.out.println(stage[i] + "에 입장합니다.");
			int qua = (int) Math.random() * 3;
			System.out.println("전투Npc의 도움을 받겠습니까?\n단, 무작위로 Npc가 정해집니다. : y/n");
			char answer = sc.next().charAt(0);
			if (answer == 'y') {
				System.out.println(npc[qua]);
			System.out.println("첫 번째 몬스터가 등장했습니다");
			System.out.println(dragon[order[0]]);
			
			while(true) {
				i++;
				System.out.println("턴 수 : " + turn);
				user[order[0]].attack(user, dragon, order[0]);
				break;
			}
			
					
					

				

			
			}

			i++;
		}

	}

}
