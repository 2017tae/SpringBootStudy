package net.datasa.Example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("jq")
public class JqController {

	
	@GetMapping("01")
	public String functionBasicConcept() {
		return "01. 기본개념";
	}
	
	@GetMapping("02")
	public String functionSelector() {
		return "02. 선택자";
	}
	
	@GetMapping("03")
	public String functionArrayFunction() {
		return "03. 배열 및 함수";
	}
	
	@GetMapping("04")
	public String functionDocument() {
		return "04. 문서객체";
	}
}
