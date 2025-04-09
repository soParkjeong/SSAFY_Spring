package com.ssafy.ws.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.ssafy.ws.dto.Student;

// @Configuration : 스프링 설정 클래스를 의미한다. (스프링 설정 XML 파일을 대신한다.)
// @ComponentScan : 스프링이 빈을 찾을 수 있도록 설정한다. (basePackages 속성을 통해 빈을 찾을 패키지를 지정할 수 있다.)
// @EnableAspectJAutoProxy : AspectJ를 사용하기 위한 설정이다. (AOP를 사용하기 위한 설정)
@Configuration
@ComponentScan(basePackages = "com.ssafy.ws")
@EnableAspectJAutoProxy
public class AppConfig {
	// 교육생 "홍길동"을 생성하는 빈을 정의한다.
    @Bean
    public Student student1() {
        return new Student("홍길동");
    }
    
}
