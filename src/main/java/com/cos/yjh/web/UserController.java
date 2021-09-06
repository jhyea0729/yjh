package com.cos.yjh.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.cos.yjh.web.dto.JoinReqDto;
import com.cos.yjh.domain.user.User;
import com.cos.yjh.domain.user.UserRepository;
import com.cos.yjh.web.dto.LoginReqDto;

@Controller
public class UserController {

	private UserRepository userRepository;
	private HttpSession session;
	
	
	// DI
	public UserController(UserRepository userRepository, HttpSession session) {
		this.userRepository = userRepository;
		this.session = session;
	}
	
	@GetMapping("/test/query/join")
	public void testQueryJoin() {
		userRepository.join("cos", "1234", "cos@nate.com");
	}
	
	@GetMapping("/test/join")
	public void testJoin() {
		User user = new User();
		user.setUsername("ssar");
		user.setPassword("1234");
		user.setEmail("ssar@nate.com");
		
		// insert into user(username, password, email) values('ssar', '1234', 'ssar@nate.com');
		userRepository.save(user);
	}
	
	@GetMapping("/home")
	public String home() {
		return "home";
	}
	
	// /WEB-INF/views/user/login.jsp
	// /WEB-INF/views/login.jsp
	
	//  /WEB-INF/views/user/login.jsp
	@GetMapping("/loginForm")
	public String loginForm() {
		return "user/loginForm";
	}
	
	@GetMapping("/joinForm")
	public String joinForm() {
		return "user/joinForm";
	}
	
	@PostMapping("/login")
	public String login(LoginReqDto dto) {
		
		// 1. username, password 받기
		System.out.println(dto.getUsername());
		System.out.println(dto.getPassword());
		// 2. DB -> 조회
		User userEntity = userRepository.mLogin(dto.getUsername(), dto.getPassword());
		
		if(userEntity == null) {
			return "redirect:/loginForm";
		}else {
			session.setAttribute("principal", userEntity);
			return "redirect:/home";
		}
		// 3. 있으면
		// 4. session에 저장
		// 5. 메인페이지를 돌려주기
	}
	
	@PostMapping("/join")
	public String join(JoinReqDto dto) {		// username=love&password=1234&email=love@nate.com

		userRepository.save(dto.toEntity());	// user 오브젝트에다가 dto에 있는거 채워넣어 
		
		return "redirect:/loginForm";	// 리다이렉션 (300)
	}
	
}



