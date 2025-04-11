package com.ssafy.mvc;

// 뷰리졸버(ViewResolver) : 논리적인 뷰의 이름을 가지고 물리적인 뷰를 가져오도록 한다.
public class ViewResolver {
	private String prefix; // 접두사
	private String suffix; // 접미사
	
	
	public ViewResolver(String prefix, String suffix) {
		super();
		this.prefix = prefix;
		this.suffix = suffix;
	}
	
	// 뷰의 이름 -> 물리적인 뷰 경로를 반환
	public String resolve(String viewName) {
		return prefix + viewName + suffix;
	}
}
