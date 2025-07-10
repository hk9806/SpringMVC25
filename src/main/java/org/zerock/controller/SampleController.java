package org.zerock.controller;


import java.util.ArrayList;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.zerock.domain.SampleDTO;
import org.zerock.domain.SampleDTOList;
import org.zerock.domain.TodoDTO;

import lombok.extern.log4j.Log4j2;

//servlet-context.xml 에서 <context:component-scan base-package="org.zerock.controller" />
@Controller
@RequestMapping("/sample/*") //http://192.168.111.104:80/controller/sample/모든 것에 반응
@Log4j2 // resources폴더에 log4j2.xml 필수
public class SampleController {

	@RequestMapping("") // 공백은 -> //http://192.168.111.104:80/controller/sample/
	public void basic() {
		
		log.info("SampleController.basic() 메소드 실행");
		log.info("리턴이 void이기 때문에 basic.jsp 파일을 찾음");
		log.info("현재 /WEB-INF/view/basic.jsp가 없으므로 크롬에는 오류가 발생");
		//리턴이 void임: [WEB-INF/views/sample.jsp]를 찾을 수 없습니다.
		//기본적으로 url에 경로에 대한 jsp를 찾으려고 함.
	} //basic
	
	@RequestMapping(value="/basic", method= {RequestMethod.GET,RequestMethod.POST})
	// http://192.168.111.104:80/controller/sample/basic->get메소드와 post메소드에 동작
	public void basicGet() {
		log.info("ampleController.basicGet() 메소드 실행-----------");
		log.info("get방식과 post방식 둘다 반응 -----------------");
		}// basicGet
	
	@GetMapping("/basicOnlyGet")
	public void basicGet2() {
		log.info("ampleController.basicGet2() 메소드 실행-----------");
		log.info("get방식 반응--------------");
	} // basicGet2 메서드 종료
	
	@PostMapping("/basicOnlyPost")
	public void basicPost2() {
		log.info("ampleController.basicPost2() 메소드 실행-----------");
		log.info("post방식 반응--------------");
	} // basicPost2
	
	
	@GetMapping("/ex01") //http://192.168.111.104:80/controller/sample/ex01?name=kkw&age=33
	public String ex01(SampleDTO dto ) { //SampleDTO dto = new SampleDTO();
		
		log.info("SampleController.ex01() 메소드 실행-----------");
		log.info("Get방식 반응--------------");
		log.info("입력 dto 확인: "+dto);
		
		return "mbcex01"; //  /WEB-INF/views/ex01.jsp -> servlet-context.xml에서 처리
	}//ex01

	@GetMapping("/ex02")//http://192.168.111.104:80/controller/sample/ex02
	private String ex02(@RequestParam("owner") String name, @RequestParam("age") int age ) {
		//프론트의 변수와 백엔드의 변수가 다를 때 사용가능
		log.info("name: "+name);
		log.info("age: "+age);
		
		return "ex02";
	}
	
	@GetMapping("/ex02List")
	//http://192.168.111.104:80/controller/sample/ex02List?ids=111&ids=222&ids=333
	public String ex02List(@RequestParam("ids") ArrayList<String> ids) {
		//리스트로 넘어오는 데이터 처리
		log.info("리스트로 넘어온 데이터 처리: "+ids);
		log.info("리스트 2번째: "+ids.get(1));
		return "ex02List";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDTOList list) {
		//url 경로에 배열로 들어오는 파라미터
		// /ex02Bean?list[0].name=kkw&list[2].age=33
		log.info("list SampleDTOs: "+list);
		return "ex02Bean";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todo) {
		
		log.info("todo: "+todo);
		return "ex03";
	}
	
	@GetMapping("/ex04") //http://192.168.111.104:80/controller/sample/ex04
	public String ex04(SampleDTO dto, @ModelAttribute("page") int page) { //int page는 게시판에 페이징기법
		//@ModelAttribute("page") 미사용시 프론트에는 전달 안됨
		//스프링에서 기본적으로 제공되는 model객체를 사용하도록 설정해야 함
		log.info("dto: "+dto); //name, age
		log.info("page: "+page);
		
		return "/sample/ex04"; //views/sample/ex04.jsp 를 찾음
	}
	
	@GetMapping("/ex05")
	public void ex05() {
		log.info("SampleController.ex05메서드 실행---------");
		
		//리턴이 void인 경우에는 자동으로[WEB-INF/views/sample/ex05.jsp]를 찾음
		//초보자 void 사용 금지
	}
	
	@GetMapping
	public @ResponseBody SampleDTO ex06() {
		// @ResponseBody SampleDTO : 응답 바디에 객체를 담아 리턴
		
		log.info("SampleController.ex06 메소드 실행-------------");
		
		SampleDTO dto = new SampleDTO();
		dto.setName("kkw");
		dto.setAge(33);
		
		return dto;
	}
 
	
	@GetMapping("/ex07")
	public ResponseEntity<String> ex07(){
		// ResponseEntity<String> 응답헤더 (200 ok, 404, 304)를 만들어 리턴
		log.info("SampleController.ex07 메소드 실행-------------");
		
		String msg="{\"name\":\"kkw\"}"; //json으로 {name : kkw}
		
		HttpHeaders header = new HttpHeaders();
		header.add("Content-Type", "application/json;charset=UTF-8");
		//헤더에 타입 추가
		
		return new ResponseEntity<String>(msg,header, HttpStatus.OK);
		// msg 에 json데이터 / header는 json타입/ 상태값 ok->200
	}
}