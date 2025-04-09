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
 * 4단계 : 뷰 리졸버 (View Resolver)를 도입
 * 			뷰의 물리적인 경로(하드 코딩)를 통해서 JSP 파일의 경로로 View 만드는 방식
 * 			-> 논리적인 경로로 조금 더 쉽게 만들어 보겠다.
 * 			논리적 경로 -> 물리적 경로
 * 			"/hello" -> "(접두사) /WEB-INF/views + "/hello".jsp (접미사)"
 * 			
 */

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	private Map<String, Controller> handlerMapings;
	private ViewResolver viewResolver;
	
	@Override
	public void init() throws ServletException {
		handlerMapings = new HashMap<>();
		viewResolver = new ViewResolver("/WEB-INF/views", ".jsp");

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
		if(controller != null) {
			// 컨트롤러를 통해서 view의 이름(논리적인 이름)
			String viewName = controller.service(request, response);
			String viewPath = viewResolver.resolve(viewName);
			// view를 포워드
			request.getRequestDispatcher(viewPath)
			       .forward(request, response);
		} else {
			response.getWriter().println("<h1>Not Found Page</h1>");
		}
	}
	
	
}
