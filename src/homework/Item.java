package homework;

public class Item {
	private int price, weaponatk;
	private String name;

	Item(String name, int price, int weaponatk) {
		this.name = name;
		this.price = price;
		this.weaponatk = weaponatk;
	}

	public int getPrice() {
		return price;
	}

	public int getWeaponatk() {
		return weaponatk;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return "이름 : " + this.getName() + ", 가격 : " + this.getPrice() + "원, 무기공격력 : " + this.getWeaponatk();
	}
}