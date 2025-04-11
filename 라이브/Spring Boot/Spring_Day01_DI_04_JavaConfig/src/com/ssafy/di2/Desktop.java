package com.ssafy.di2;

import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Desktop implements Computer{
	private String CPU;
	private String RAM;
	private String SSD;
	private String power;
	
	//설정자, 접근자
	
	//생성자
	public Desktop() {
		System.out.println("데스크탑 만들어 졌어요~~");
	}
	
	public String getInfo() {
		return "데스트톱";
	}
}
