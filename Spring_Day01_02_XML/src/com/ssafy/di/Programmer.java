package com.ssafy.di;

public class Programmer {
	private String name;
	private int age;
	
	// 오늘의 주된 관심사
	// 프로그래머는 PC가 필요해
	private Computer computer;
	
	public Programmer() {}

	public void setComputer(Computer computer) {
		this.computer = computer;
	}

	// 객체 생성 의존성을 제거
	public Programmer(Computer computer) {
		// 가지고 있는 데스크 탑이 있다면 그거 주면서 고용.
		this.computer = computer;
	}
	
	public void coding() {
		System.out.println(computer.getInfo() + " 개발 고고");
	}
}
