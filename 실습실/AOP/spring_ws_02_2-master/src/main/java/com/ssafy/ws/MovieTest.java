package com.ssafy.ws;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MovieTest {
	public static void main(String[] args) {
        ApplicationContext context = new GenericXmlApplicationContext("applicationContext.xml");

        Person audience = context.getBean("audience", Person.class);
        try {
            audience.doSomething();
        } catch (CallException e) {
            // 예외 발생 시 별도 출력 필요 없음 (AOP에서 처리)
        }
    }
}
