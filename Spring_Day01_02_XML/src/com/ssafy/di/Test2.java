package com.ssafy.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class Test2 {
	public static void main(String[] args) {
		// 설정 파일을 이용하여 컨테이너를 좀 들고오자
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext2.xml");

		Programmer p = context.getBean("programmer", Programmer.class);

		p.coding();
	}
}
