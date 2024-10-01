package homework;

public interface Attack {

	public void attack(User[] user, MonDragon[] dragon, int order);

	public void attack(User[] user, MonDemon[] demon, int order);

	public void attack(User[] user, MonMachine[] machine, int order);
}