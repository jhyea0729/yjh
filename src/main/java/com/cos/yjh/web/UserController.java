package com.cos.yjh.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.yjh.web.dto.LoginReqDto;

@Controller
public class UserController {

	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// /WEB-INF/views/login.jsp
	// /WEB-INF/views/user/login.jsp
	@GetMapping("/loginForm")
		public String login() {	// 함수 이름은 별로 안중요하다
		return "user/loginForm";
	}
	// http://localhost:8080/login -> login.jsp
	// views/user/login.jsp
	
	@GetMapping("/joinForm")
	public String join() {
	return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {	// 디스패쳐 서블릿이 일 많이 한다.
		// 1. username, password 받기
		System.out.println(dto.getUsername());	// 스프링이 정한 규칙을 따르면 간편하게 할 수 있다
		System.out.println(dto.getPassword());
		// 2. DB -> 조회
		// 3. 있으면
		// 4. session 에 저장 (request에 저장하면 응답하면 끝난다)
		// 5. 메인페이지를 돌려주기
		return "home";
	}
}