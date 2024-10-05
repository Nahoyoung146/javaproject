package homework;

public class Item extends Rpg {
	private int price, weaponatk;

	Item() {
		super();
		this.price = 0;
		this.weaponatk = 0;
	}

	Item(String name, int price, int weaponatk) {
		super(name);
		this.price = price;
		this.weaponatk = weaponatk;
	}

	public int getPrice() {
		return price;
	}

	public int getWeaponatk() {
		return weaponatk;
	}

	public String toString() {
		return "이름 : " + this.getName() + ", 가격 : " + this.getPrice() + "원, 무기공격력 : " + this.getWeaponatk();
	}
}