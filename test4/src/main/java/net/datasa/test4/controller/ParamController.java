package net.datasa.test4.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;

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
	
	@GetMapping("input1")
	public String input1(@RequestParam("id") String id, @RequestParam("pw") String pw){
		log.debug("id={}, pw={}", id, pw);
		return "redirect:/home";
	}
}
