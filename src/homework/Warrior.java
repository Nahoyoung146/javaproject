package homework;

public class Warrior extends User {
	Warrior(String name, int maxhp, int maxmp, int maxatk) {
		super(name, maxhp, maxmp, maxatk);
	}

	public void Skill(User[] user, Monster mon) {
		System.out.println(this.getName() + "이(가) 스킬을 시전했습니다\n적에게 상당한 피해를 입혔습니다.");
		mon.setHp(mon.getHp() - this.getSkillatk());
		this.setMp(this.getMp() - 30);
		System.out.println("적 체력 : " + mon.getHp());
	}

	public void Sword(Monster mon) {
		System.out.println("파워슬래시를(을) 사용했습니다.");
		mon.setHp(mon.getHp() - 100 * this.getLevel());
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}

	public void Blade(Monster mon) {
		System.out.println("강탈를(을) 사용했습니다.\n추가 골드를 획득합니다.");
		mon.setHp(mon.getHp() - 50 * this.getLevel());
		this.setMoney(this.getMoney() + 50 * this.getLevel());
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}

	public void Blunt(Monster mon) {
		System.out.println("이중공격를(을) 사용했습니다.\n스킬의 효과로 한번 더 데미지가 들어갑니다.");
		mon.setHp(mon.getHp() - 50 * this.getLevel() - this.getAtk());
		this.setMp(this.getMp() - 50);
		System.out.println("적 체력 : " + mon.getHp());
	}
}