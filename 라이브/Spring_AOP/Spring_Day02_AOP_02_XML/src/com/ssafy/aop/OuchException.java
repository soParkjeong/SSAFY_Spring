package com.ssafy.aop;

public class OuchException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public void handleException() {
		System.out.println("병원가자");
	}
	
}
