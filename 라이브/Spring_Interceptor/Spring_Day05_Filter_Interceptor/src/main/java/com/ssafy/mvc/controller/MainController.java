package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.ssafy.mvc.model.dto.User;

import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

	@GetMapping("/hello")
	public String hello() {
		return "hello";
	}

	@GetMapping("/login")
	public String loginForm() {
		return "/user/loginForm";
	}

	@PostMapping("/login")
	public String login(@ModelAttribute User user, HttpSession session) {
		session.setAttribute("loginUser", user.getId());
		return "redirect:hello";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 로그아웃을 하는 방법
		// 1. 세션에서 해당 로그인 정보만 삭제
//		session.removeAttribute("loginUser");
		// 2. 세션 자체를 초기화
		session.invalidate();
		return "redirect:/";
	}
	
	@GetMapping("/regist")
	public String regist() {
		return "regist";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
