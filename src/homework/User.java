package homework;

public class User extends Rpg implements Attack {
	private int money, exp, level, skillatk, needexp, addexp, addhp, addmp, addatk, addskillatk;
	private String job;

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
	}

	User(String name, int atk, int skillatk, String job) {
		super(name, atk);
		this.money = 0;
		this.exp = 0;
		this.level = 1;
		this.skillatk = skillatk;
		this.needexp = 500;
		this.addexp = 5;
		this.addhp = 100;
		this.addmp = 10;
		this.job = job;
		this.addatk = 5;
		this.addskillatk = 5;
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

	public void Expup(Monster monster) {
		int a = (int) Math.random() * monster.getDifficulty() + 1;
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
			this.setHp(this.getHp() + this.getAddhp());
			this.setMp(this.getMp() + this.getAddmp());
			super.setAtk(super.getAtk() + this.getAddatk());
			this.setSkillatk(this.getSkillatk() + this.getAddskillatk());

		}
	}

	public void MoneyUp(Monster monster) {
		int a = 10 + (int) Math.random() * monster.getDifficulty() * 10 + 1;
		this.setMoney(this.getMoney() + a);
	}

	public void BuyItems() {

	}

	public void attack(User user, Monster monster) {
		System.out.println(user.getName() + "이가 공격을 합니다.");
		monster.setHp(monster.getHp() - user.getAtk());
	}
}