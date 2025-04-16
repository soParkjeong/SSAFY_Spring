package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

//HandlerInterceptor 인터페이스를 구현해야한다.
@Component
public class BInterceptor implements HandlerInterceptor {
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//boolean 반환 -> T : 진행 / F : 그만
		System.out.println("B : Pre");
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
		//컨트롤러 찍고 온상태 -> ModelAndView 객체가 있음
		//예외 발생 시 -> 미실행
		System.out.println("B : Post");
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		//View가 전달된 후 실행 (finally 같은 너낌) 
		//예외 발생이 ex 객체가 담겨 있음, 아니라면 null
		System.out.println("B : After");
	}
}
