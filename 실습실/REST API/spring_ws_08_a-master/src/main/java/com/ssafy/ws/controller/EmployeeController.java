package com.ssafy.ws.controller;

import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ssafy.ws.model.dto.EmployeeDto;
import com.ssafy.ws.model.service.EmployeeService;

/**
 * EmployeeController는 직원 정보를 관리하는 컨트롤러입니다. RESTful 서비스를 구현합니다.
 * 
 * - @RestController : 해당 클래스가 RESTful 서비스를 처리하는 컨트롤러임을 명시합니다. - @RequestMapping
 * : 해당 클래스의 모든 메소드에 공통적으로 적용되는 URL을 지정합니다.
 */
@RequestMapping("/employee")
@RestController
public class EmployeeController {

		// "hello"라는 문자열을 사용자한테 반환...!!
		@RequestMapping("/test1")
		@ResponseBody
		public String test1() {
			return "hello";// 문자열 그 자체...! 뷰의 이름 X (논리적인 View)
		}
		
		@RequestMapping("/test2")
		@ResponseBody
		public String test2() throws JsonProcessingException{
			
			//객체 즉, JSON 문자열로 전환한 데이터를 전달...!
			String jsonString="";
			EmployeeDto employee=new EmployeeDto(1001,"홍길동","과장","개발부");
			ObjectMapper objectMapper=new ObjectMapper();
			jsonString=objectMapper.writeValueAsString(employee);
			return jsonString;// 문자열 그 자체...! 뷰의 이름 X (논리적인 View)
		}
		
		@RequestMapping("/test3")
		@ResponseBody
		public EmployeeDto test3() throws JsonProcessingException{
			EmployeeDto employee=new EmployeeDto(1001,"홍길동","과장","개발부");
			return employee;
		}
		
		//Spring MVC-> ResponseBody 어노테이션 핸들러에는 객체가 반환될 때,
		//JSON 데이터 포맷으로 변환...!!
		//
		//JSON 자유자재로 데이터를 변형해서 보낼 수 있긴한데..
		//문제점: HTTP Response 객체 <- 응답상태(statusCode), 헤더(header) 변경 X
		@RequestMapping("/test4")
		@ResponseBody
		public Map test4() throws JsonProcessingException{
			Map<String, Object>map=new HashMap<>();
			map.put("id", "ssafy");
			map.put("password", "1q2w3e4r");
			map.put("datas", new int[] {1,2,3,4});
			
			Map<String,String>map2=new HashMap<>();
			map2.put("address", "Seoul");
			map2.put("age", "20");
			
			map.put("profile", map2);
			
			return map;
		}
		
		//Sping의 특별한 응답 객체...ResponseEntity 클래스!
		//Spring MVC-> ResponseBody 어노테이션 핸들러에는 객체가 반환될 때
		//JSON 데이터 포맷으로 변환..!
		@RequestMapping("/test5")
		@ResponseBody
		public ResponseEntity test5(){
			Map<String, Object>map=new HashMap<>();
			map.put("id", "ssafy");
			map.put("password", "1q2w3e4r");
			map.put("datas", new int[] {1,2,3,4});
			
			Map<String,String>map2=new HashMap<>();
			map2.put("address", "Seoul");
			map2.put("age", "20");
			
			map.put("profile", map2);
			
			//응답 상태만을 반환할 때... 
//			return new ResponseEntity<>(HttpStatusCode.valueOf(200));
//			return new ResponseEntity<>(HttpStatus.OK);
			
			//+데이터를 같이 전달...!
			return new ResponseEntity<>(map,HttpStatus.ACCEPTED);
		}
		
		// Spring의 특별한 응답 객체.. ResponseEntity 클래스!
		// Builder 생성 패턴을 통해서 생성해보기...!
		@RequestMapping("/test6")
		@ResponseBody
		public ResponseEntity test6() {
			Map<String, Object> map = new HashMap<>();
			map.put("id", "ssafy");
			map.put("password", "1q2w3e4r");
			map.put("datas", new int[] { 1, 2, 3, 4 });

			Map<String, String> map2 = new HashMap<>();
			map2.put("address", "seoul");
			map2.put("age", "20");

			map.put("profile", map2);


//			// 상태코드만을 전달할 때...!
			return ResponseEntity
					.ok()			// 상태코드를 200 OK...
					.build();		// body 안에 데이터 없음...
			// 상태코드 + 데이터 실어서 전달...!
//			return ResponseEntity
//					.ok()			// 상태코드를 200 OK...
//					.body(map);		// body 안에 데이터 있으면...
//			return ResponseEntity
////					.badRequest()
////					.noContent()
////					.notFound()
		}
		
	@Autowired
	private EmployeeService service;

	/*
	 * ResponseEntity: ResponseEntity는 HTTP 응답을 포함하는 클래스입니다. HTTP 헤더와 상태 코드, 응답 본문을
	 * 포함합니다. 제너릭 타입을 사용하여 응답 본문의 타입을 지정하며 ResponseEntity 객체를 반환합니다. 예를 들어
	 * ResponseEntity<String>은 응답 본문이 문자열인 경우 사용합니다.
	 * 
	 * @ResponseBody가 있는 메소드의 경우, 스프링 MVC는 메소드의 반환 값을 HTTP 응답 본문으로 변환하여 클라이언트에게
	 * 전송합니다. (기본적으로 JSON 형식으로 변환) RESTful 서비스에서는 ResponseEntity 객체를 반환하는 것이 일반적입니다.
	 * 예를 들어, new ResponseEntity<>(HttpStatus.OK, employee)는 HTTP 200 상태 코드와
	 * employee 객체를 반환합니다.
	 * 
	 * ResponseEntity는 다양한 정적 메서드를 제공합니다. - ResponseEntity.ok()는 HTTP 200 상태 코드를
	 * 반환합니다. - ResponseEntity.created()는 HTTP 201 상태 코드를 반환합니다. -
	 * ResponseEntity.noContent()는 HTTP 204 상태 코드를 반환합니다. - ...
	 */

//	 Q1. 사원 목록 조회
//	 GET /employee
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public ResponseEntity<?> list() throws Exception {
		List<EmployeeDto> employees = service.getAllEmployees();
		return ResponseEntity.ok(employees);
	}

	
//	 Q2. 사원 상세 조회
//	 GET /employee/{id}
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> detail(@PathVariable("id") int id) throws Exception {
		EmployeeDto employee = service.getEmployeeById(id);
		return ResponseEntity.ok(employee);
	}

	
//	 Q3. 사원 등록
//	 POST /employee
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> insert(EmployeeDto employee) throws Exception {
		int result = service.insert(employee);
//		return new ResponseEntity<>(result, result == 1 ? HttpStatus.CREATED : HttpStatus.BAD_REQUEST);
		//위의 한 줄을 이렇게 써도 됨 
		if (result == 1) {
			return (ResponseEntity<?>) ResponseEntity.created(URI.create("/employee/" + employee.getId()));
		} else {
			return ResponseEntity.badRequest().build();
		}
	}

	
//	 Q4. 사원 수정
//	 PUT /employee/{id}
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<?> update(@PathVariable("id") int id, EmployeeDto employee) throws Exception {
		employee.setId(id);
		int result = service.update(employee);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}

//	 Q5. 사원 삭제
//	 DELETE /employee/{id}
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<?> delete(@PathVariable("id") int id) throws Exception {
		int result = service.delete(id);
		return new ResponseEntity<>(result, result == 1 ? HttpStatus.NO_CONTENT : HttpStatus.BAD_REQUEST);
	}
}
