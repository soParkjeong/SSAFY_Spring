package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test {
	public static void main(String[] args) {
		// 설정 파일을 이용하여 컨테이너를 좀 들고오자
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");
		
		// 기본 컨셉은 싱글톤
		Desktop desktop = (Desktop)context.getBean("desktop");
		Desktop desktop2 = (Desktop)context.getBean("desktop");
		System.out.println(desktop.getInfo());
		
		Programmer p = context.getBean("programmer", Programmer.class);
		p.setComputer(desktop);
		p.coding();
		
		System.out.println(desktop == desktop2);
	}
}
