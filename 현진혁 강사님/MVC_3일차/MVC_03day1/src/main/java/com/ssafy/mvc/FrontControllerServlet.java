package com.ssafy.mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/*
 * 1단계 : 프론트 컨트롤러(FrontController)를 통해서 흐름을 단순화
 * 			- 중앙 집중식 요청 처리가 가능
 * 			- 공통의 로직을 프론트를 통해서 처리가능 (중복 코드 제거)
 * 
 */

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		// 문제 1. 사용자가 요청을 보냈을 때의 경로(path)를 문자열로 가져오기
		
		// 사용자가 보내온 (request)에서 URL 경로(path)를 추출해라
		String uri = request.getRequestURI(); // 사용자가 실제 요청한 URL
		
		// 웹 어플리케이션의 상대 경로 (해당 프로젝트가 등록된 root 경로)
		String contextPath = request.getContextPath();
		
		System.out.println("uri : " + uri);
		System.out.println("contextPath : " + contextPath);
		
		String path = uri.substring(contextPath.length());
		System.out.println("path : " + path);
		
		
		// 경로에 해당하는 서블릿을 생성 -> 호출
		// 문제점 : 매 요청마다 서블릿 객체를 생성해줘야 한다 (리소스 낭비)
		// 		  라이프 사이클 구조를 어기게 됨. init() -> service() 반복 -> destroy()
		if (path.equals("/hello")) {
			new HelloServlet().service(request, response);
		} else if (path.equals("/user")) {
			new UserServlet().service(request, response);
		} else {
			response.getWriter().println("<h1>Index Page</h1>");
		}
	}
	
}
