package net.datasa.test_security;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	
	@GetMapping({"/", ""})
	public String home() {
		return "home";
	}
	
	@GetMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("view1")
	public String view1() {
		return "view1";
	}
	
	@GetMapping("thyme")
	public String thyme() {
		return "thyme";
	}
	
	@GetMapping("view2")
	public String view2(@AuthenticationPrincipal AuthenticatedUser user) {
		log.debug("id:{}", user.getId());
		log.debug("pw:{}", user.getPassword());
		return "view2";
	}
}
