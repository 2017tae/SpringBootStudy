package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("ck")
@Slf4j
public class CookieController {
	
	@GetMapping("cookie1")
	public String cookie1(HttpServletRequest request, HttpServletResponse response) {
		
		log.debug(request.getRemoteAddr());
		//쿠키 생성
		Cookie a = new Cookie("str", "abcdeg");
		Cookie b = new Cookie("num", "123");
		a.setMaxAge(60*60*24*3);
		b.setMaxAge(60*60*24*3);
		a.setPath("/");
		b.setPath("/");
		response.addCookie(a);
		response.addCookie(b);
		log.debug("cookie1 실행");
		return "redirect:/";
	}
	
	@GetMapping("cookie2")
	public String cookie2(@CookieValue(name="num", defaultValue="0")int num,
			@CookieValue(name="str", defaultValue="")String s) {
		
		log.debug("num 쿠키:{}", num);
		log.debug("str 쿠키:{}", s);
		return "redirect:/";
	}
	
	@GetMapping("cookie3")
	public String cookie3(HttpServletRequest request, HttpServletResponse response) {
		
		log.debug(request.getRemoteAddr());
		
		Cookie num = new Cookie("num", null);
		Cookie str = new Cookie("str", null);
		Cookie cnt = new Cookie("cnt", null);
		num.setMaxAge(0);
		str.setMaxAge(0);
		cnt.setMaxAge(0);
		num.setPath("/");
		str.setPath("/");
		cnt.setPath("/");
		response.addCookie(str);
		response.addCookie(num);
		response.addCookie(cnt);
		return "redirect:/";
	}
}
