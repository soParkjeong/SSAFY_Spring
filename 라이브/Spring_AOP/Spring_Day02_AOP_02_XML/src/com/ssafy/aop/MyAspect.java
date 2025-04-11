package com.ssafy.aop;

import org.aspectj.lang.ProceedingJoinPoint;

public class MyAspect {
	public void before() {
		System. out.println("컴퓨터를 부팅한다. / 커피 한잔 한다.");
	}
	
	public void afterReturning(int num) {
		System.out.println("Git Commit 한다. : " + num + "시간을 투자한");
	}
	
	public void afterThrowing(Throwable th) {
		System.out.println("조퇴를 한다.");
		if (th instanceof OuchException) {
			((OuchException) th).handleException();
		}
	}
	
	public void after() {
		System.out.println("보람찬 하루를 마무리 한다.");
	}
	
	public void around(ProceedingJoinPoint pjt) {
		this.before();
		Integer num = 0;
		
		try {
			num = (Integer) pjt.proceed();
			this.afterReturning(num);// 핵심 관심 사항 동작
		} catch (Throwable e) {
			e.printStackTrace();
			this.afterThrowing(e);
		} finally {
			this.after();
		}	
	}

}
