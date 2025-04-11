package di_04_의존성주입;

import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop();
		
		Programmer p = new Programmer(desktop);
		
		p.coding();
		
		Programmer p2 = new Programmer();
		p2.setComputer(desktop);
		p2.coding();
		
		Scanner sc = new Scanner(System.in);
		Programmer p3 = new Programmer();
		
		while (true) {
			p3.setComputer(ComputerFactory.getComputer(sc.next()));
			p3.coding();
		}
	}
}
