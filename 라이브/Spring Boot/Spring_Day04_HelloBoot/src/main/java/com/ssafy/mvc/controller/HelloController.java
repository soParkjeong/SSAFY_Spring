package com.ssafy.mvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HelloController {
	
	@GetMapping("/hello")
	public String getMethodName(Model model) {
		//반환타입이 String 이라는 것은 View 이름이 String 이라는 의미 
		model.addAttribute("msg","Hello Boot");
		return "hello";//WEB-INF/view/hello.jsp로 포워딩 
	}

}
 