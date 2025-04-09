package di_03_타입의존성제거;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop(); // 데스크탑 준비 완료
		Laptop laptop = new Laptop();
		
		Programmer p = new Programmer(desktop);
		Programmer pr = new Programmer(laptop);
		p.coding();
		pr.coding();
	}
}
