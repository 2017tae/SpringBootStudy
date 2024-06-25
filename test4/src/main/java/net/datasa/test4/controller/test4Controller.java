package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class test4Controller {
	
	@GetMapping("/")
	public String home() {
		return "home";
	}
}
