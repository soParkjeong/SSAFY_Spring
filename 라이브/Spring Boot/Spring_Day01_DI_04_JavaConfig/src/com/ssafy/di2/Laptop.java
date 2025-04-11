package com.ssafy.di2;


public class Laptop implements Computer {
	private String CPU;
	private String RAM;
	private String SSD;
	private String power;
	
	//설정자, 접근자
	
	//생성자
	
	public String getInfo() {
		return "노트북";
	}
}
