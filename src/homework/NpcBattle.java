package homework;

public class NpcBattle extends Npc implements Attack {
	NpcBattle() {
		super();
	}

	NpcBattle(String name, int atk) {
		super(name, atk);
	}

	public void attack(User user, Monster monster, Npc npc) {
		System.out.println(npc.getName() + "이가 공격을 합니다.");
		monster.setHp(monster.getHp() - npc.getAtk());
	}
}