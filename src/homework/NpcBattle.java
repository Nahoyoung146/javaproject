package homework;

public class NpcBattle extends Npc implements Attack {
	NpcBattle() {
		super();
	}

	NpcBattle(String name, int atk) {
		super(name, atk);
	}

	public void attack(User[] user, MonDragon[] dragon, int order) {
		System.out.println(this.getName() + "이(가) 공격을 합니다.");
		dragon[order].setHp(dragon[order].getHp() - this.getAtk());
		System.out.println("적 체력 : " + dragon[order].getHp());
	}

	public void attack(User[] user, MonDemon[] demon, int order) {
		System.out.println(this.getName() + "이(가) 공격을 합니다.");
		demon[order].setHp(demon[order].getHp() - this.getAtk());
		System.out.println("적 체력 : " + demon[order].getHp());
	}

	public void attack(User[] user, MonMachine[] machine, int order) {
		System.out.println(this.getName() + "이(가) 공격을 합니다.");
		machine[order].setHp(machine[order].getHp() - this.getAtk());
		System.out.println("적 체력 : " + machine[order].getHp());
	}

	public String toString() {
		return "이름 : " + this.getName() + ", 공격력 : " + this.getAtk();
	}
}