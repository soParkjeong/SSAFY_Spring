package com.ssafy.mvc;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 2단계 : 서블릿을 조금 더 효율적으로 사용하도록 Map을 사용하여 관리
 * 
 */

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	// 별도의 Map을 통해서 Servlet을 관리
	// 경로 (path) - 서블릿(Servlet)
	private Map<String, HttpServlet> handlerMapings;
	
	@Override
	public void init() throws ServletException {
		handlerMapings = new HashMap<>();
		
		// 기존 서블릿 객체를 생성해서 등록
		handlerMapings.put("/hello", new HelloServlet());
		handlerMapings.put("/user", new UserServlet());
		
		// 라이프 사이클 구조에 맞도록 init 과정을 각각 실행
		
		for (HttpServlet servlet : handlerMapings.values()) {
			servlet.init();
		}
	}
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 사용자가 실제 요청한 URL
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		// 경로에 해당하는 서블릿을 Map을 통해서 가져오기
		HttpServlet servlet = handlerMapings.get(path);
		if (servlet != null) {
			// 찾은 서블릿으로 요청 위임 처리
			servlet.service(request, response);
		} else {
			response.getWriter().println("<h1>Not Found Page</h1>");
		}
	}
	
	@Override
	public void destroy() {
		// 각 서블릿을 destroy
		for (HttpServlet servlet : handlerMapings.values()) {
			servlet.destroy();
		}
	}
	
}
