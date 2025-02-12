package net.datasa.web3;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
@RequiredArgsConstructor
public class PersonController {

	// Service라는 어노테이션으로 이미 메모리에 올라와있음 이를 자동 주입
//	@Autowired
//	PersonService personService;

	// RequiredArgsConstructor => final, @NotNull 변수에
	private final PersonService personService;

	@GetMapping("test")
	public String test() {
		personService.test();

		return "redirect:/";
	}

	@GetMapping("save")
	public String save() {
		return "Input";
	}
	
	@GetMapping("select")
	public String select() {
		return "select";
	}
	
	@PostMapping("save")
	public String savePerson(@RequestParam("ID")String id, @RequestParam("name")String name, @RequestParam("age")int age) {
		PersonDTO p = PersonDTO.builder().ID(id).name(name).age(age).build();
		personService.save(p);
		return "redirect:/";
	}
	
	@PostMapping("member")
	public String member(Model model, @RequestParam("ID")String ID) {
		try {
			PersonDTO p = personService.getMember(ID);
			model.addAttribute("id", p.getID());
			model.addAttribute("name", p.getName());
			model.addAttribute("age", p.getAge());
		}catch(Exception e) {
			model.addAttribute("err", "해당 유저를 찾을 수 없습니다");
			e.printStackTrace();
		}
		
		return "ID"; 
	}
	
	@GetMapping("view")
	public String view(Model model, @RequestParam("id")String ID) {
		try {
			PersonDTO p = personService.getMember(ID);
			model.addAttribute("id", p.getID());
			model.addAttribute("name", p.getName());
			model.addAttribute("age", p.getAge());
		}catch(Exception e) {
			model.addAttribute("err", "해당 유저를 찾을 수 없습니다");
			e.printStackTrace();
		}
		
		return "ID"; 
	}
	
	@GetMapping("members")
	public String members(Model model) {
		List<PersonDTO> list = personService.selectAll();
		
		model.addAttribute("results", list);
		return "members";
	}
	
	@GetMapping("info/{id}")
	public String info(@PathVariable("id")String id, Model model) {
		try {
			PersonDTO p = personService.getMember(id);
			model.addAttribute("id", p.getID());
			model.addAttribute("name", p.getName());
			model.addAttribute("age", p.getAge());
		}catch(Exception e) {
			model.addAttribute("err", "해당 유저를 찾을 수 없습니다");
			e.printStackTrace();
		}

		return "ID";
	}
	
	@GetMapping("delete/{id}")
	public String deleteMember(@PathVariable("id")String id) {
		personService.delete(id);
		return "redirect:/members";
	}
}
