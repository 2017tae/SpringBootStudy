package net.datasa.web2.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.Person;

/**
 * 타임리프 문법 연습
 */
@Controller
@Slf4j
@RequestMapping("th")
public class ThymeleafController {
	@GetMapping("thymeleaf1")
	public String thymeleaf1(Model model) {
		String str = "문자열";
		int num = 99999;
		Person p = new Person("홍길동", 20, "010-1234-5678");
		String tag = "<marquee>HTML태그를 포함한 문자열</marquee>";
		String url = "https://google.com";
		
		model.addAttribute("str", str);
		model.addAttribute("num", num);
		model.addAttribute("person", p);
		model.addAttribute("tag", tag);
		model.addAttribute("url", url);
		
		int n1 = 1000000;
		double n2 = 123.4567;
		double n3 = 0.5;
		Date today = new Date();
		
		model.addAttribute("n1", n1);
		model.addAttribute("n2", n2);
		model.addAttribute("n3", n3);
		model.addAttribute("today", today);	
		
		String values = "Java,HTML,CSS";
		String card = "1111-2222-3333-4444";
		model.addAttribute("values", values);
		model.addAttribute("card", card);
		
		return "thView/thymeleaf1";
	}
	
	@GetMapping("thymeleaf2")
	public String thymeleaf2(Model model) {
		
		String name = "abc";
		int code = 1;
		
		ArrayList<String> list = new ArrayList<>();
		list.add("abc");
		list.add("가나다라");
		list.add("1234");
		
		HashMap<String, Object> map = new HashMap<>();
		map.put("product", "키보드");
		map.put("price", 500);
		
		ArrayList<Person> personlist = new ArrayList<>();
		personlist.add(new Person("김", 10, "010-1111-2222"));
		personlist.add(new Person("이", 20, "010-3333-2222"));
		personlist.add(new Person("박", 30, "010-4444-2222"));
		
		model.addAttribute("name", name); // [[${map}]]
		model.addAttribute("code", code);
		model.addAttribute("list", list);
		model.addAttribute("map", map);
		model.addAttribute("personlist", personlist);
		
		return "thView/thymeleaf2";
	}
}
