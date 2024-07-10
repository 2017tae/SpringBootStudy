package net.datasa.web2.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.Person;

@Controller
@RequestMapping("lom")
@Slf4j
public class LomController {
	
	@GetMapping("lombok")
	public String lombokTest() {
		Person p = new Person();
		p.setName("홍길동");
		p.setAge(10);
		p.setPhone("010-1111-1111");
		System.out.println(p);
		
		Person p2 = new Person("김", 20, "010-222-2222");
		
		return "redirect:/";
	}
	
	@GetMapping("logger")
	public String loggerTest() {
		log.error("error 메소드로 출력함");
		log.warn("warn 메소드로 출력함");
		log.info("info 메소드로 출력함");
		log.debug("debug 메소드로 출력함");
		log.trace("trace 메소드로 출력함");
		
		String a = "abc";
		int b = 12;
		log.debug("a={}, b={}", a, b);
		
		return "redirect:/";
	}


}
