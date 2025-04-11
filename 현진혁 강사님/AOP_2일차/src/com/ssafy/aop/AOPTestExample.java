package com.ssafy.aop;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

// 프록시 (proxy) 패턴을 통해서 계산기 "더하기", "빼기"에 대한 연산을 대리 수행

interface Calculator {
	int add (int a, int b);
	int substract(int a, int b);
}

@Component("realCalculator")
class CalculatorService implements Calculator {

	@Override
	public int add(int a, int b) {
		System.out.println("더하기 진행 : " + a + " + " + b);
		return a + b;
	}

	@Override
	public int substract(int a, int b) {
		System.out.println("빼기 진행 : " + a + " - " + b);
		return a - b;
	}
	
}

// 계산기 요청을 대리 수행할 프록시 클래스
@Primary // 최우선적으로 실행
@Component
class CalculatorProxy implements Calculator {

	private final Calculator calc;

	@Autowired
	public CalculatorProxy(@Qualifier("realCalculator") Calculator calc) {
		this.calc = calc;
	}

	@Override
	public int add(int a, int b) {
		
		// 로그기능 추가
		System.out.println("[LOG] 더하기 연산을 시작 합니다. " + a + ", " + b);
		
		int result =  calc.add(a, b);
		
		System.out.println("[LOG] 연산의 결과는 : " + result);
		
		return result;
	}

	@Override
	public int substract(int a, int b) {
		
		System.out.println("[LOG] 빼기 연산을 시작 합니다. " + a + ", " + b);
		
		int result =  calc.substract(a, b);
		
		System.out.println("[LOG] 연산의 결과는 : " + result);
		
		return result;
	}
}

@Configuration
@ComponentScan(basePackages = "com.ssafy.aop")
class Config {
	// 추가로 생성할 빈이 있다면 @Bean 어노테이션을 첨부한 메서드를 정의
}


public class AOPTestExample {
	public static void main(String[] args) {
		// DI / IoC 의존성 주입
		ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
		
		// 계산기 객체를 가져와서 계산을 수행
		Calculator calc = context.getBean(Calculator.class);
		
		calc.add(3, 4);
	}
}
