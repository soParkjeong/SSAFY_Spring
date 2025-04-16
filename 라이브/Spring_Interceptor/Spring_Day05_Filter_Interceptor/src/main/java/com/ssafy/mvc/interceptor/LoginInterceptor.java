package com.ssafy.mvc.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@Component
public class LoginInterceptor implements HandlerInterceptor{
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		//특정 작업을 하려고 했을떄 로그인한 상태여야만... 진행하겠다!
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser") == null	) {
			response.sendRedirect("login");
			return false;
		}
		
		
		return true;
	}
}
