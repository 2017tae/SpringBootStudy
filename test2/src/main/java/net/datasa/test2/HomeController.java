package net.datasa.test2;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
//	GetMapping({"", "/", "home}) 여러 개를 매핑 가능하다.
	@GetMapping("home")
	public String home() {
		//필요한 자바 코드
		System.out.println("home메소드 지나감.");
		//템플릿으로 이동
		return "home";
	}
	
	@GetMapping("sub")
	public String sub() {
		System.out.println("sub메소드 지나감");
		return "subView";
	}
}
