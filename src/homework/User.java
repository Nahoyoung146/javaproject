package homework;

import java.util.ArrayList;

public abstract class User extends Rpg implements Attack, Skill {
	private int money, exp, level, skillatk, needexp, addexp, addhp, addmp, addatk, addskillatk, maxhp, maxmp;
	private String job, futurejob;

	User() {
		super();
		this.money = 0;
		this.exp = 0;
		this.level = 1;
		this.skillatk = 0;
		this.needexp = 500;
		this.addexp = 5;
		this.addhp = 100;
		this.addmp = 10;
		this.job = "가나다";
		this.addatk = 5;
		this.addskillatk = 5;
		this.maxhp = 0;
		this.maxmp = 0;
	}

	User(String name, String futurejob) {
		super(name);
		this.money = 0;
		this.exp = 0;
		this.level = 1;
		this.skillatk = 50;
		this.needexp = 500;
		this.addexp = 5;
		this.addhp = 100;
		this.addmp = 10;
		this.job = "모험가";
		this.addatk = 5;
		this.addskillatk = 5;
		this.maxhp = 1000;
		this.maxmp = 100;
		this.futurejob = futurejob;
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

	public int getAddexp() {
		return addexp;
	}

	public void setAddexp(int addexp) {
		this.addexp = addexp;
	}

	public int getAddhp() {
		return addhp;
	}

	public void setAddhp(int addhp) {
		this.addhp = addhp;
	}

	public int getAddmp() {
		return addmp;
	}

	public void setAddmp(int addmp) {
		this.addmp = addmp;
	}

	public String getJob() {
		return job;
	}

	public void setJob(String job) {
		this.job = job;
	}

	public int getAddatk() {
		return addatk;
	}

	public void setAddatk(int addatk) {
		this.addatk = addatk;
	}

	public int getAddskillatk() {
		return addskillatk;
	}

	public void setAddskillatk(int addskillatk) {
		this.addskillatk = addskillatk;
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

	public String getFuturejob() {
		return futurejob;
	}

	public void Expup(ArrayList<Monster[]> Mon, int order, int order2) {
		int a = (int) (Math.random() * Mon.get(order)[order2].getDifficulty()) + 1;
		this.setExp(this.getExp() + a);
		if (this.getExp() >= this.getNeedexp()) {
			this.setLevel(this.getLevel() + 1);
			this.setExp(this.getExp() - this.getNeedexp());
			this.setAddexp(this.getAddexp() + 10);
			this.setAddhp(this.getAddhp() + 100);
			this.setAddmp(this.getAddmp() + 10);
			this.setAddatk(this.getAddatk() + 5);
			this.setAddskillatk(this.getAddskillatk() + 5);
			this.setNeedexp(this.getNeedexp() + this.getAddexp());
			this.setHp(this.getMaxhp() + this.getAddhp());
			this.setMp(this.getMaxmp() + this.getAddmp());
			super.setAtk(super.getAtk() + this.getAddatk());
			this.setSkillatk(this.getSkillatk() + this.getAddskillatk());
			System.out.println(this.getName() + "이(가) 레벨업했습니다.");
		}
		System.out.println(this.getName() + "의 경험치가 " + a + " 증가하였습니다.");
	}

	public void MoneyUp(ArrayList<Monster[]> Mon, int order, int order2) {
		int a = 10 + (int) (Math.random() * Mon.get(order)[order2].getDifficulty() * 10) + 1;
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

	public void attack(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2, int order3) {
		System.out.println(user.get(order).getName() + "이(가) 공격을 합니다.");
		Mon.get(order2)[order3].setHp(Mon.get(order2)[order3].getHp() - user.get(order2).getAtk());
		System.out.println("적 체력 : " + Mon.get(order2)[order3].getHp());
	}
	
	public static void initial(ArrayList<User> user1, User[] user2) {
		int i = 0;
		while (i < user1.size()) {
			user1.clear();
			user1.add(user2[i]);
			user2[i].setHp(user2[i].getMaxhp());
			user2[i].setMp(user2[i].getMaxmp());
			user2[i].setAtk(user2[i].getAtk());
			i++;
		}
	}

	public abstract void Skill(ArrayList<User> user, ArrayList<Monster[]> Mon, int order, int order2);

	public String toString() {
		return "이름 : " + this.getName() + ", 레벨 : " + this.getLevel() + ", 공격력 : " + this.getAtk() + ", HP : "
				+ this.getHp() + ", MP" + this.getMp() + ", 경험치 : " + this.getExp() + ", 직업 : " + this.getJob();
	}
}