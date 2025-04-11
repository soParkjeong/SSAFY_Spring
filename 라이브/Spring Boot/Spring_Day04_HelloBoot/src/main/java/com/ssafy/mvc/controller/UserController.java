package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RequestParam;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

//import jakarta.servlet.http.HttpServletRequest;

@Controller
public class UserController {
	
//	의존성 주입-> 필드/설정자/생성자 주입 
//	@Autowired
//	private UserService userService;
	
	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";//WEB-INF/view/user/loginForm.jsp로 포워딩(이동)
	}
	
	//이 방법은 귀찮음(->밑의 방법을 사용함)
//	@PostMapping("/login")
//	public String login(HttpServletRequest request) {
//		String id=request.getParameter("id");
//	}
	
//  ->이 방법을 사용함
//	@PostMapping("/login")
//	public String login(@RequestParam("id") String id, @RequestParam("pw")String pw) {
//		
//	}
	
	//로그인 정보는 -> 세션에다가 저장해야겠다!
	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		System.out.println(user);
//		userService.login(user);//정석 방법 
		
		session.setAttribute("loginUser", user);
		
		return "redirect:hello";//리다이렉트 방식으로 하려면 이렇게!!
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//로그아웃을 하는 방법
		//1. 세션에서 해당 로그인 정보만 삭제
//		session.removeAttribute("loginUser");
		//2. 세션 자체를 초기화 
		session.invalidate();
		//return "hello"; -> 그냥 포워딩 방식으로 하면 로그인을 하고 로그아웃을 해도 url에 /logout이 남아있음
		//리다이렉스 방식으로 하기
		return "redirect:/";//이렇게 하면 로그아웃 버튼을 누르면 main페이지로 자동 이동됨 
	}
}
