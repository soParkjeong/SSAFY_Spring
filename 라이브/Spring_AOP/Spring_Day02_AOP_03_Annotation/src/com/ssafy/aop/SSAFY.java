package com.ssafy.aop;

import java.util.Random;

public class SSAFY implements Person {
	// 필드는 과감하게 생략
	
	// SSAFY 일상
	public Integer coding() throws OuchException {
		System.out.println("열심히 공부를 작성한다."); // 핵심 관심 사항
		
		if (new Random().nextBoolean()) throw new OuchException();
		
		return (int) (Math.random() * 10) + 1; // 시간 반환
	}
}
