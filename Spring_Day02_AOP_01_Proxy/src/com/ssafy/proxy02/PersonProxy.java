package com.ssafy.proxy02;

import java.util.Random;

public class PersonProxy implements Person {
	
	// 프록시 객체에 주입할 인간.
	private Person person;

	// 설정자 주입
	public void setPerson(Person person) {
		this.person = person;
	}

	@Override
	public void coding() {
		System.out.println("컴퓨터를 부팅한다. / 커피를 한잔한다."); // 이전에 수행되어야 할 기능
		
		
		try {
			person.coding(); // 동적 바인딩.
			
			if (new Random().nextBoolean()) throw new OuchException();
			
			System.out.println("Git Commit 한다."); // 정상적으로 종료가 되었을 때
		} catch (OuchException e) {
			e.handleException();
			System.out.println("반차를 한다.");
			System.out.println("옆에 동료에게 Commit 해달라고 한다."); // 비정상 종료가 되었을 때
		} finally {
			System.out.println("침대와 한몸이 된다."); // 모든게 끝났을 때
		}
	}

}
