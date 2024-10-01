package homework;

import java.util.ArrayList;

public interface Attack {

	public void attack(ArrayList<User> user, MonDragon[] dragon, int order, int order2);

	public void attack(ArrayList<User> user, MonDemon[] demon, int order, int order2);

	public void attack(ArrayList<User> user, MonMachine[] machine, int order, int order2);
}