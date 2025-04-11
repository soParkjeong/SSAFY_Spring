package com.ssafy.di1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

public class Programmer {
	private String name;
	private int age;
	
	//오늘의 주된 관심! 
	//프로그래머는 PC가 필요해!
//	@Autowired
	private Computer computer;
	
	public Programmer() {
	}
	
	//생성자 주입
//	@Autowired
	public Programmer(Computer computer) {
		this.computer = computer;
	}
	
	//설정자 주입
//	@Autowired
	public void setComputer(@Qualifier("laptop")Computer computer) {
		this.computer = computer;
	}

	public void coding() {
		System.out.println(computer.getInfo()+"으로 개발 고고");
	}
	
}
