package homework;

import java.util.ArrayList;

public abstract class User extends Rpg implements Attack, Skill {
	private int money, exp, level, skillatk, needexp, maxhp, maxmp, maxatk, maxskillatk;
	private String job;

	User(String name, int maxhp, int maxmp, int maxatk) {
		// 기본 생성자는 쓸 일이 없으면 오히려 만들지 않는게 좋다. -> 기본 생성자는 정의를 하지 않았을 경우 무조건적으로 만들어진다. (객체에
		// 대한 접근이 쉽다.)
		// 객체를 생성할때 정확하게 요구되는 매개변수(데이터)들을 확실하게 전달 받을 수 있다.
		super(name);
		this.money = 0;
		this.exp = 0;
		this.level = 1;
		this.skillatk = 50;
		this.needexp = 100;
		this.job = "모험가";
		this.maxhp = maxhp;
		this.maxmp = maxmp;
		this.maxatk = maxatk;
		this.maxskillatk = 50;
		super.setHp(this.getMaxhp());
		super.setMp(this.getMaxmp());
		super.setAtk(this.getMaxatk());
		this.setSkillatk(this.getMaxskillatk());
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public int getExp() {
		return exp;
	}

	public void setExp(int exp) {
		this.exp = exp;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getSkillatk() {
		return skillatk;
	}

	public void setSkillatk(int skillatk) {
		this.skillatk = skillatk;
	}

	public int getNeedexp() {
		return needexp;
	}

	public void setNeedexp(int needexp) {
		this.needexp = needexp;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getMaxhp() {
		return maxhp;
	}

	public void setMaxhp(int maxhp) {
		this.maxhp = maxhp;
	}

	public int getMaxmp() {
		return maxmp;
	}

	public void setMaxmp(int maxmp) {
		this.maxmp = maxmp;
	}

	public int getMaxatk() {
		return maxatk;
	}

	public void setMaxatk(int maxatk) {
		this.maxatk = maxatk;
	}

	public int getMaxskillatk() {
		return maxskillatk;
	}

	public void setMaxskillatk(int maxskillatk) {
		this.maxskillatk = maxskillatk;
	}

	public void Expup(Monster mon) {
		int a = (int) (Math.random() * mon.getDifficulty()) + 1;
		this.setExp(this.getExp() + a);
		if (this.getExp() >= this.getNeedexp()) {
			this.setLevel(this.getLevel() + 1);
			this.setExp(this.getExp() - this.getNeedexp());
			this.setNeedexp(this.getNeedexp() + this.getLevel() * 10);
			this.setHp(this.getMaxhp() + this.getLevel() * 10);
			this.setMp(this.getMaxmp() + this.getLevel() * 10);
			this.setMaxhp(this.getMaxhp() + this.getLevel() * 10);
			this.setMaxmp(this.getMaxmp() + this.getLevel() * 10);
			super.setAtk(super.getAtk() + this.getLevel() * 10);
			this.setMaxatk(this.getMaxatk() + this.getLevel() * 10);
			this.setSkillatk(this.getSkillatk() + this.getLevel() * 10);
			this.setMaxskillatk(this.getMaxskillatk() + this.getLevel() * 10);
			System.out.println(this.getName() + "이(가) 레벨업했습니다.");
		}

		else
			System.out.println(this.getName() + "의 경험치가 " + a + " 증가하였습니다.");
	}

	public void MoneyUp(Monster mon) {
		int a = 10 + (int) (Math.random() * mon.getDifficulty() * 10) + 1;
		this.setMoney(this.getMoney() + a);
		System.out.println(this.getName() + "이(가) " + a + "원을(를) 획득하였습니다.");
	}

	public void recovery() {
		this.setHp(this.getHp() + 1);
		this.setMp(this.getMp() + 5);
		if (this.getHp() >= this.getMaxhp()) {
			this.setHp(this.getMaxhp());
		}
		if (this.getMp() >= this.getMaxmp()) {
			this.setMp(this.getMaxmp());
		}
	}

	public void attack(User user, Monster mon) {
		System.out.println(user.getName() + "이(가) 공격을 합니다.");
		mon.setHp(mon.getHp() - user.getAtk());
		System.out.println("적 체력 : " + mon.getHp());
	}

	public abstract void attack1(User[] user, Monster mon);

	public abstract void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2);

	public String toString() {
		return "이름 : " + this.getName() + ", 레벨 : " + this.getLevel() + ", HP : " + this.getHp() + ", MP : "
				+ this.getMp() + ", 공격력 : " + this.getAtk() + ", 경험치 : " + this.getExp() + ", 직업 : " + this.getJob()
				+ ", 보유골드 :" + this.getMoney();
	}
}