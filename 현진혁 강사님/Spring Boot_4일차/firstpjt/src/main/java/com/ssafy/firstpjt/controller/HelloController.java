package com.ssafy.firstpjt.controller;

import com.ssafy.firstpjt.dto.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.service.invoker.RequestParamArgumentResolver;

import java.util.HashMap;
import java.util.Map;

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello"; // 논리 이름 -> 물리 경로 (ViewResolver prefix, suffix)
    }

    // 모든 컨트롤러(handler)에게는 해당 request 객체와 response 객체를 통해
    // 가공할 수 있는 정보이면 이를 통해서 파라미터(매개변수) 전달
    // ArgumentResolver : request, response -> 원하는 객체로 바꿔서 전달
    @RequestMapping("/test1")
    public String test1(HttpServletRequest request, HttpServletResponse response) {
        HttpSession session = request.getSession();
        session.setAttribute("myData", "gildong");
        String name = request.getParameter("name"); // GET(queryString), POST(formData) 방식 모든 데이터를 가져올 수 있음
        System.out.println(name);
        return "index";
    }

    // 여기서 가져온 session 매개변수는 사실 request 객체를 통해서 가공해준 것
    @RequestMapping("/test2")
    public String test2(HttpSession session) {
        return "index";
    }

    // @RequestParam - getParameter 메서드를 통해서 데이터를 가공
    // 해당 어노테이션을 붙이면 -> RequestParamArgumentResolver 동작 그 값을 가공해서 주입
    // 주의점 : 매개변수가 컴파일 시에 이름이 날아갈 수 있기 때문에 파라미터 명을 명시적으로 작성해주는 것이 좋음
    @RequestMapping("/test3")
    public String test3(@RequestParam("name") String name) {
        return "index";
    }

    // /test4/123 , /test4/456 -> 하나의 글자에 매핑 시킬 수 있는 와일드 카드 -> ?
    //                          -> 0개 이상의 글자를 매핑시킨다면 와일드 카드 -> *
    // Model 매개변수는 Request Attribute 설정 맵
    // Model -> Hashmap 여기에 넣게 되는 Attribute-> request 속성에 복사
    @RequestMapping("/test4/{name}")
    public String test4(@PathVariable String name, HttpServletRequest request, Model model) {
        String uri = request.getRequestURI();
        model.addAttribute("URI", uri);
        model.getAttribute("URI");
        return "index";
    }

    @RequestMapping("/test5")
    public String test5(@RequestBody User user, Model model) {
        model.addAttribute("user", user);

        return "index";
    }

    // 문자열로 -> getParameters를 사용 -> 다수의 필드를 하나의 객체로 맵핑
    // 폼 데이터를 일괄적으로 받아서 검증할 때 활용
    @RequestMapping("/test6")
    public String test6(@ModelAttribute User user, Model model) {
        model.addAttribute("user", user);

        return "index";
    }

    // Map을 통해서 모든 파라미터를 일괄적으로 받아온다
    @RequestMapping("/test7")
    public String test7(@RequestParam Map<String, String> map, Model model) {
        model.addAttribute("data", map);
        return "index";
    }

    @RequestMapping("/test8")
    public String test8(@RequestParam MultiValueMap<String, String> map, Model model) {
        model.addAttribute("data", map);
        return "index";
    }

    @RequestMapping("/test9")
    public String test9(@CookieValue(value="AUT_ID", required = false, defaultValue = "UNKWOUN") String jid, Model model) {
        model.addAttribute("sessionId", jid);
        return "index";
    }

    // 사실 이렇게 내부적으로 가져와도 된다....!
    @RequestMapping("/test10")
    public String test10(HttpSession session, Model model) {
        String jid = (String) session.getAttribute("JSESSIONID");
        model.addAttribute("sessionId", jid);
        return "index";
    }

    @RequestMapping("/test11")
    public String test11(@RequestHeader("user-agent") String userAgent, Model model) {
        model.addAttribute("userAgent", userAgent);
        return "index";
    }

    @ResponseBody
    @RequestMapping("/test12")
    public ResponseEntity<?> test12(Model model) {
        // 맵 객체 -> 문자열 JSON {"id" : "ssafy", "pw" : "1q2w3e4r"}
        Map<String, Object> map = new HashMap<>();
        map.put("id", "ssafy");
        map.put("pw", "1q2w3e4r");
        // 객체를 생성 : 디자인 패턴 -> 빌더 패턴

        return ResponseEntity.ok(map);
    }

}
