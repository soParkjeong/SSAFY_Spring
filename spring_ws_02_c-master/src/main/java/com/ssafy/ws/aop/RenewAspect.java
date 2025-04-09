package com.ssafy.ws.aop;

import java.time.LocalDateTime;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import com.ssafy.ws.dto.Student;

@Aspect
@Component
public class RenewAspect {
	// Q5. 학생의 입실 및 퇴실 시에 시간을 갱신하는 메소드를 작성하시오.
	// hint. Pointcut 표현식은 OR 연산자인 || 를 사용하여서 두 개의 메소드에 대해서 동시에 적용하도록 할 수 있습니다.
	@AfterReturning("execution(* com.ssafy.ws.dto.Student.enter(..)) || execution(* com.ssafy.ws.dto.Student.leave(..))")
	public void afterUpdateDate(JoinPoint joinPoint) {
		Student student = (Student) joinPoint.getTarget();
		student.setUpdated(LocalDateTime.now());
    }
	
}
