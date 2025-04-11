package com.ssafy.mvc;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.ssafy.mvc.dto.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
    protected void service(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        // 비즈니스 로직 처리
        List<User> users = new ArrayList<>();
        users.add(new User("user1", "홍길동"));
        users.add(new User("user2", "김철수"));
        
        // 모델 데이터 설정
        request.setAttribute("users", users);
        
        // JSP로 포워딩
        request.getRequestDispatcher("/WEB-INF/views/user/list.jsp")
        	   .forward(request, response);
    }
}