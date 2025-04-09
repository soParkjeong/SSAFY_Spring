package di_02_객체생성의존성제거;

public class Test {
	public static void main(String[] args) {
		Desktop desktop = new Desktop(); // 데스크탑 준비 완료
		
		Programmer p = new Programmer(desktop);
		p.coding();
	}
}
