package homework;

public class Item extends Rpg {
	private int price, weaponatk;
	private boolean weapon;

	Item() {
		super();
		this.price = 0;
		this.weaponatk = 0;
		this.weapon = false;
	}

	Item(String name, int price, int weaponatk, boolean weapon) {
		super(name);
		this.price = price;
		this.weaponatk = weaponatk;
		this.weapon = weapon;
	}

	public int getPrice() {
		return price;
	}

	public int getWeaponatk() {
		return weaponatk;
	}

	public boolean isWeapon() {
		return weapon;
	}

	public void setWeapon(boolean weapon) {
		this.weapon = weapon;
	}
	
	public String toString() {
		return "이름 : " + this.getName() + ", 가격 : " + this.getPrice() + ", 무기공격력 : " + this.getWeaponatk();
	}
}