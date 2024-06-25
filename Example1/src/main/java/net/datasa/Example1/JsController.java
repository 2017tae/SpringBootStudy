package net.datasa.Example1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("js")
public class JsController {

	
	@GetMapping("00")
	public String script() {
		System.out.println("1");
		return "00. 스크립트";
	}
	
	@GetMapping("01")
	public String basicGrammer() {
		return "01. 기본문법";
	}
	
	@GetMapping("02")
	public String operator() {
		return "02. 연산자";
	}
	
	@GetMapping("03")
	public String functionControlStatement() {
		return "03. 제어문";
	}
	
	@GetMapping("04")
	public String functionArray() {
		return "04. 배열";
	}
	
	@GetMapping("05")
	public String functionDate() {
		return "05. Date객체";
	}
	
	@GetMapping("06")
	public String functionMath() {
		return "06. Math객체";
	}
	
	@GetMapping("07")
	public String functionString() {
		return "07. String객체";
	}
	
	@GetMapping("08")
	public String functionObject() {
		return "08. Object객체";
	}
	
	@GetMapping("09")
	public String functionJson() {
		return "09. JSON";
	}
	
	@GetMapping("10")
	public String functionFunction() {
		return "10. 함수";
	}
	
	@GetMapping("11")
	public String functionConstructor() {
		return "11. 객체생성자 함수";
	}
	
	@GetMapping("12")
	public String functionHtmlDom() {
		return "12. HTML DOM";
	}
	
	@GetMapping("13")
	public String functionHtmlDomEvent() {
		return "13. HTML DOM 이벤트";
	}
	
	@GetMapping("14")
	public String functionHtmlBom() {
		return "14. HTML BOM";
	}
}
