package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

/**
 * 쿠키 테스트
 */
@Controller
@Slf4j
@RequestMapping("ck")
public class CookieController {

	@GetMapping("cookie1")
	public String cookie1(HttpServletRequest request, HttpServletResponse response) {
		
		log.debug(request.getRemoteAddr());
		//쿠키 생성
		Cookie a = new Cookie("str", "abcdedg");
		Cookie b = new Cookie("num", "123");
		//쿠키 종료 시점
		a.setMaxAge(60*60*24*3);
		b.setMaxAge(60*60*24*3);
		//쿠키 경로
		a.setPath("/");
		b.setPath("/");
		//쿠키 보내서 저장
		response.addCookie(a);
		response.addCookie(b);
		
		log.debug("cookie1 실행");
		return "redirect:/";
	}
	
	@GetMapping("cookie2")
	public String cookie2(
			@CookieValue(name="num", defaultValue = "0") int num,
			@CookieValue(name="str", defaultValue = "") String s
			) {
		
		log.debug("num 쿠키 : {}", num);
		log.debug("str 쿠키 : {}", s);

		return "redirect:/";
	}
	
	@GetMapping("cookie3")
	public String cookie3(HttpServletResponse response) {
		//삭제할 쿠키와 같은 이름으로 쿠키 객체 생성 (value는 null또는 아무거나)
		//유지시간을 0초로 지정
		//응답객체를 통해 쿠키 저장//쿠키 생성
		Cookie a = new Cookie("str", "");
		Cookie b = new Cookie("num", null);
		//쿠키 종료 시점
		a.setMaxAge(0);
		b.setMaxAge(0);
		//쿠키 경로
		a.setPath("/");
		b.setPath("/");
		//쿠키 보내서 저장
		response.addCookie(a);
		response.addCookie(b);
		return "redirect:/";
	}
	
}
