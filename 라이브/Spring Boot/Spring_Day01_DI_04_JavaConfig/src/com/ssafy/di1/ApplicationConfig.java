package com.ssafy.di1;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.Scope;

@Configuration
public class ApplicationConfig {
	
	@Bean
	public Desktop desktop() {
		return new Desktop();
	}
	
	@Bean
//	@Scope()
	public Programmer programmer() {
		//설정자 주입 
		Programmer pr=new Programmer();
		pr.setComputer(desktop());
		
		//생성자 주입
//		Programmer pr2=new Programmer(desktop());
		
		return pr;
	}

}
