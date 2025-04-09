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
 * 3단계 : MVC 패턴으로 기존의 하위 서블릿을 재작성해보자.
 * 			문제 : 각 Servlet 클래스에서 MVC 로직이 상당히 복잡하게 얽혀있다.
 * 					FrontControllerServlet(C) -> HelloServlet(MVC)
 * 										      -> UserServlet(MVC)
 * 					기존의 하위 서블릿들을 Controller로 변경하자
 * 					(이제 하위 서블릿들 너네 직접 응답 X)
 * 
 * 					기존 : 각 서블릿에서 직접 view를 만들고 응답처리하는 방식
 * 					변경 : 컨트롤러 (Controller) : 뷰(view)의 경로로 반환하는 방식으로 변경
 * 					장접 : 각 클래스의 역할이 분명해진다. + 서블릿을 상속 받는 구조에서 유연한 설계가 가능한 Controller 구조로 변경
 * 
 */

@WebServlet("/")
public class FrontControllerServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Controller> handlerMapings;
	
	@Override
	public void init() throws ServletException {
		handlerMapings = new HashMap<>();

		// 기존 서블릿 객체를 생성해서 등록
		handlerMapings.put("/hello", new HelloController());
		handlerMapings.put("/user", new UserController());
	}
	
	@Override
	protected void service(HttpServletRequest request, 
			HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI(); // 사용자가 실제 요청한 URL
		String contextPath = request.getContextPath();
		String path = uri.substring(contextPath.length());
		
		// 경로에 해당하는 서블릿을 Map을 통해서 가져오기
		Controller controller = handlerMapings.get(path);
		if (controller != null) {
			// 컨트롤러를 통해서 view 경로로 가져오소
			String viewPath = controller.service(request, response);
			
			// view를 포워드
			request.getRequestDispatcher(viewPath).forward(request, response);
		
		} else {
			response.getWriter().println("<h1>Not Found Page</h1>");
		}
	}
	
	
}
