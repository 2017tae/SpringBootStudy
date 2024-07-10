package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.Member;
import net.datasa.web2.domain.Person;

@Controller
@Slf4j
@RequestMapping("param")
public class ParamController {
	
	//http://localhost:8888/param/view1 요청 처리 메소드
	@GetMapping("view1")
	public String view1() {
		//templates/paramView/view1.html로 포워딩
		return "paramView/view1";
	}
	
	@GetMapping("input1")
	public String input1(
			@RequestParam(name="id", defaultValue="") String id,
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("phone") String phone,
			@RequestParam("com") String com) {
		
		log.debug("ID:{}, PW:{}, 이름:{}, 전화:{}, 통신사:{}"
				, id, pw, name, phone, com);
		
		return "redirect:/";
	}
	
	@GetMapping("view2")
	public String view2() {
		return "paramView/view2";
	}
	
	@PostMapping("input2")
	public String input2(@ModelAttribute Member m) {
		
		log.debug("객체 값 : {}", m);
		return "redirect:/";
	}

	@GetMapping("model")
	public String model(Model model) {
		String str = "abcde";
		int num = 11233;
		Person p = new Person("김", 20, "010");
		
		model.addAttribute("str", str);
		model.addAttribute("n", num);
		model.addAttribute("person", p);
		
		return "paramView/model";
	}
	
}
