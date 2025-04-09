package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class CarTest {
	public static void main(String[] args) {
		ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

		Person driver = context.getBean("driver", Person.class);

		try {
			driver.doSomething();
		} catch (GasException e) {
			// 예외가 발생해도 이미 after_th와 after가 출력되므로 추가 처리 불필요
		}
	}
}
