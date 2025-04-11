package com.ssafy.di1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
	public static void main(String[] args) {
		//설정파일을 이용하여 컨테이너를 좀 들고오자
		//설정파일에 대한 경로를 작성
		
		ApplicationContext context=new AnnotationConfigApplicationContext(ApplicationConfig.class);
		
		Desktop d1=context.getBean("desktop",Desktop.class);
		Desktop d2=context.getBean("desktop",Desktop.class);
		
		System.out.println(d1==d2);
		
		Programmer p=context.getBean(Programmer.class);
		p.coding();
	}
}
