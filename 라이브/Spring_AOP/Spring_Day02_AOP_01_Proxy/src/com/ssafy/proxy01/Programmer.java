package com.ssafy.proxy01;

import java.util.Random;

public class Programmer {
	// 필드는 과감하게 생략
	
	// 프로그래머 일상
	public void coding() {
		System.out.println("컴퓨터를 부팅한다. / 커피를 한잔한다."); // 이전에 수행되어야 할 기능
		
		
		try {
			System.out.println("열심히 코드를 작성한다."); // 핵심 관심 사항
			
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
