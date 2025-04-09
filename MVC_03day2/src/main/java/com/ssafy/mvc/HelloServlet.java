package com.ssafy.mvc;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;

public class HelloServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 비즈니스 로직 처리
        String message = "안녕, 서블릿";
        
        // 모델 데이터 설정
        request.setAttribute("message", message);
        
        // JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/hello.jsp")
               .forward(request, response);
    }
}
