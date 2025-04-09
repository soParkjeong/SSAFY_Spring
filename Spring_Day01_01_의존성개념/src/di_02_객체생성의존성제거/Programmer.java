package di_02_객체생성의존성제거;

public class Programmer {
	private String name;
	private int age;
	
	// 오늘의 주된 관심사
	// 프로그래머는 PC가 필요해
	private Desktop desktop;
	
	// 객체 생성 의존성을 제거
	public Programmer(Desktop desktop) {
		// 가지고 있는 데스크 탑이 있다면 그거 주면서 고용.
		this.desktop = desktop;
	}
	
	public void coding() {
		System.out.println(desktop.getInfo() + " 개발 고고");
	}
}
