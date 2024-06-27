package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.datasa.test4.domain.Member;
import net.datasa.test4.domain.Person;

@Controller
@RequestMapping("param")
@Slf4j
public class ParamController {
	
	// localhost/param/view1 요청 처리
	@GetMapping("view1")
	public String view1() {
		// templates/paramView/view1으로 포워딩
		return "paramView/view1";
	}
	
	//RequestParam vs PathVariable
//	@GetMapping("input1/{id}")
//	public String input1(@PathVariable String id){
//		log.debug("id={}", id);
//		return "redirect:/home";
//	}
	@GetMapping("input1")
	public String input1(
			@RequestParam(name="id", defaultValue = " ")String id, 
			@RequestParam("pw") String pw,
			@RequestParam("name") String name,
			@RequestParam("phoneNum") String phoneNum,
			@RequestParam("com") String com){
		log.debug("id={}, pw={}, 이름={}, 전화={}, 통신사={}", id, pw, name, phoneNum, com);
		return "redirect:/home";
	}
	
	@GetMapping("view2")
	public String view2() {
		return "paramView/view2";
	}
	
//	@PostMapping("input2")
//	public String input2(
//			@RequestParam(name="id", defaultValue = " ")String id, 
//			@RequestParam("pw") String pw,
//			@RequestParam("name") String name,
//			@RequestParam("phoneNum") String phoneNum,
//			@RequestParam("com") String com){
//		log.debug("id={}, pw={}, 이름={}, 전화={}, 통신사={}", id, pw, name, phoneNum, com);
//		return "redirect:/home";
//	}
	@PostMapping("input2")
	public String input2(@ModelAttribute Member m){
		log.debug("객체={}", m);
		log.debug("id={}, pw={}, 이름={}, 전화={}, 통신사={}", m.getId(), m.getPw(), m.getName(), m.getPhoneNum(), m.getCom());
		return "redirect:/home";
	}
	
	@GetMapping("model1")
	public String model1(Model model) {
		String str = "abcde";
//		int num = 112233;
//		Person p = Person.builder().age(10).name(str).phoneNum("010-0000-000").build();
//		model.addAttribute("str");
//		model.addAttribute("n");
		model.addAttribute("str", str);
		log.debug("hello:");
		return "model1";
	}
}
