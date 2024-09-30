package homework;

public class Item extends Rpg {
	private int price, weaponatk;
	
	Item(){
		super();
		this.price=0;
		this.weaponatk=0;
	}
	
	Item(int price, int weaponatk){
		super();
		this.price=price;
		this.weaponatk=weaponatk;
	}

	public int getPrice() {
		return price;
	}

	public int getWeaponatk() {
		return weaponatk;
	}
}