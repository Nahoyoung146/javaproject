package homework;

public class Magician extends User {
	Magician() {
		super();
	}

	Magician(String name, String job) {
		super(name, job);
	}

	public void SkillWa() {
		System.out.println(super.getName() + "이(가) 스킬을 시전했습니다\t아군들의 체력이 회복되었습니다.");

	}

	public void ClassUpMa() {
		if (super.getLevel() == 10) {
			super.setJob("마법사");
		}
	}
	
	public void MagicBolt() {
		
	}
	
	public void Apocylpse() {
		
	}
}