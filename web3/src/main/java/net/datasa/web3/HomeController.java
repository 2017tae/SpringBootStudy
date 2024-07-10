package net.datasa.web3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class HomeController {
	@GetMapping({"/","home"})
	public String home() {
		return "home";
	}
}
