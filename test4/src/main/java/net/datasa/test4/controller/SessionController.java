package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import net.datasa.test4.domain.LoginDTO;

/*
세션
 */

@Controller
@RequestMapping("ss")
@Slf4j
public class SessionController {

	// 세션에 값 저장
	@GetMapping("session1")
	public String session1(HttpSession session) {
		session.setAttribute("name", "abcde");
		return "redirect:/";
	}

	// 세션에서 값 읽기
	@GetMapping("session2")
	public String session2(HttpSession session) {
		String s = (String) session.getAttribute("name");
		log.debug("session:{}", s);
		return "ss/session2";
	}

	// 세션 값 삭제
	@GetMapping("session3")
	public String session3(HttpSession session) {
		session.removeAttribute("name");
		return "redirect:/";
	}

	@GetMapping("login")
	public String login() {
		return "ss/login";
	}

	@PostMapping("login")
	public String loginPost(@ModelAttribute LoginDTO loginDto, HttpSession session, Model model) {
		
		if(loginDto.getId().equals("abc") && loginDto.getPassword().equals("123")) {
			session.setAttribute("id", loginDto.getId());
			return "redirect:/";
		}else {
			model.addAttribute("error", "아이디 혹은 비밀번호가 일치하지 않습니다.");
			return "ss/login";
		}
		
		
	}

	@GetMapping("logout")
	public String logout(HttpSession session) {
		session.removeAttribute("id");
		return "redirect:/";
	}

	@GetMapping("loginTest")
	public String loginTest(HttpSession session, Model model) {
		String id = (String) session.getAttribute("id");
		if(id == null) {
			return "redirect:/";
		}
		model.addAttribute("id", id);
		return "ss/loginTest";

	}
}
