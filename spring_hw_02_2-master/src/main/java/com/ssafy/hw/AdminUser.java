package com.ssafy.hw;

import java.util.Random;

public class AdminUser implements User {

	@Override
	public void useApp() throws ApplicationException {
	    System.out.println("애플리케이션을 관리합니다.");
	    // 예외 발생 코드 
	    if (new Random().nextBoolean()) {
	        System.out.println("애플리케이션에 문제가 생겨 점검합니다.");
	        throw new ApplicationException();
	    }
	}

}
