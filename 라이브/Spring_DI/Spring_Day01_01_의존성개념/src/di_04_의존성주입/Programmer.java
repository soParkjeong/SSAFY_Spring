package di_04_의존성주입;

public class Programmer {
	private String name;
	private int age;
	private Computer computer;
	
	public Programmer() {}
	
	public Programmer(Computer computer) {
		this.computer = computer;
	}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo() + " 개발 고고");
	}
}
