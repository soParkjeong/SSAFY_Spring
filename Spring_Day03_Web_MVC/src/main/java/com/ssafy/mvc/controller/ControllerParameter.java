package com.ssafy.mvc.controller;

import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class ControllerParameter {
	
	@GetMapping("/test1")
	public String test1() {
		return "test1";
	}
	
	// 데이터도 같이 보내고 싶다면 -> 반환타입 ModelAndView
	@GetMapping("/test2-1")
	public String test2_1(Model model) {
		// 모델 바구니 준비해서 데이터 보내기
		model.addAttribute("msg", "model data");
		
		return "test2";
	}
	
	@GetMapping("/test2-2")
	public String test2_2(Map<String, Object> model) {
		// 모델 바구니 준비해서 데이터 보내기
		model.put("msg", "map data");
		
		return "test2";
	}
	
	// 파라미터 값을 가지고 오고 싶다.
	@GetMapping("/test3")
	public String test3(Model model, HttpServletRequest request, HttpSession session) {
		String id = request.getParameter("id");
		
		model.addAttribute("id", id);
		
		return "test3";
	}
	
	@GetMapping("/test3-1")
	public String test3_1(Model model, @RequestParam("id") String id, @RequestParam(value = "pw", defaultValue = "0000") String pw) {

		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		
		return "test3";
	}
	
}
