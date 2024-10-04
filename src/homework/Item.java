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

	Item(int price, int weaponatk, boolean weapon) {
		super();
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
}