package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

/**
 * 세션 사용
 */

@Slf4j
@Controller
@RequestMapping("ss")
public class SessionController {

	//세션에 값 저장
	@GetMapping("session1")
	public String session1(HttpSession session) {
		session.setAttribute("name", "abcde");
		return "redirect:/";
	}
	
	//세션에서 값 읽기
	@GetMapping("session2")
	public String session2(HttpSession session) {
		String s = (String) session.getAttribute("name");
		log.debug("세션의 값 : {}", s);
		return "ssView/session1";
	}
	
	//세션 값 삭제
	@GetMapping("session3")
	public String session3(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/";
	}
	
	//로그인 페이지로 이동
	@GetMapping("login")
	public String login() {
		return "ssView/login";
	}
	
	//로그인 처리
	@PostMapping("login")
	public String loginProcess(
			HttpSession session,
			@RequestParam("id") String id,
			@RequestParam("password") String pw) {
		
		log.debug("로그인폼에서 입력한 값:{}/{}", id,pw);
		//아이디가 "abc"이고 비밀번호가 "123"이면 로그인 처리
		
		if (id.equals("abc") && pw.equals("123")) {
			session.setAttribute("loginId", id);
			return "redirect:/";
		}
		else {
			return "ssView/login";
		}
	}
	
	//로그아웃
	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("loginId");
		return "redirect:/";
	}
	
	//로그인 확인 페이지
	@GetMapping("loginTest")
	public String loginTest(HttpSession session) {
		
		String id = (String) session.getAttribute("loginId");
		if (id == null) {
			return "redirect:/";
		}
		
		return "ssView/loginTest";
	}
	
	
}
