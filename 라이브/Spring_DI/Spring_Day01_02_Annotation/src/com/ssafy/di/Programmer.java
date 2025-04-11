package com.ssafy.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("p")
public class Programmer {
	private String name;
	private int age;
	
	@Autowired
	private Computer computer;
	
	public Programmer() {}

//	@Autowired
//	public Programmer(Computer computer) {
//		this.computer = computer;
//	}

//	@Autowired
//	public void setComputer(@Qualifier("desktop") Computer computer) {
//		this.computer = computer;
//	}
	
	public void coding() {
		System.out.println(computer.getInfo() + " 개발 고고");
	}
}
