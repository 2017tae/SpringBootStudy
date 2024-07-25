package net.datasa.web3;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("jq")
@Slf4j
public class JqueryController {
	
	@GetMapping("1")
	public String jquery1() {
		return "jqView/jquery1";
	}
	
	@GetMapping("2")
	public String jquery2() {
		return "jqView/jquery2";
	}
	
	@GetMapping("3")
	public String jquery3() {
		return "jqView/jquery3";
	}
	
	@GetMapping("4")
	public String jquery4() {
		return "jqView/jquery4";
	}
	
	@GetMapping("5")
	public String jquery5() {
		return "jqView/jquery5";
	}
}
