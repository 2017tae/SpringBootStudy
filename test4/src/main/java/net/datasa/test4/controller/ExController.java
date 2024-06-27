package net.datasa.test4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.extern.slf4j.Slf4j;
import net.datasa.test4.domain.CalcDTO;
import net.datasa.test4.service.CalcService;

@Controller
@RequestMapping("ex")
@Slf4j
public class ExController {

	@Autowired
	CalcService calcService;
	
	@GetMapping("calc1")
	public String calc1() {
		return "ex/calc1";
	}

	@PostMapping("calc1")
	public String calculation1(@RequestParam("num1") String num1, @RequestParam("num2") String num2,
			@RequestParam("operator") int operatr, Model model) {

		int sum = 0;
		try {
			switch (operatr) {
			case 1:
				sum = Integer.parseInt(num1) + Integer.parseInt(num2);
				break;

			case 2:
				sum = Integer.parseInt(num1) - Integer.parseInt(num2);
				break;

			case 3:
				sum = Integer.parseInt(num1) * Integer.parseInt(num2);
				break;

			case 4:
				sum = Integer.parseInt(num1) / Integer.parseInt(num2);
				break;

			case 5:
				sum = Integer.parseInt(num1) % Integer.parseInt(num2);
				break;

			default:
				throw new Exception("연산자 오류");
			}
		} catch (Exception e) {
			e.printStackTrace();
			return "ex/calc1";
		}
		log.debug("num1={}, num2={}, operatr={}, sum={}", num1, num2, operatr, sum);
		model.addAttribute("sum", sum);
		return "redirect:/ex/calc1Result";
	}

//	@PostMapping("calc1")
//	public String calculation1(@RequestParam("num1")String num1, @RequestParam("num2")String num2, @RequestParam("operator")int operatr) {
//		int sum = 0;
//		switch(operatr) {
//			case 1: 
//				sum = Integer.parseInt(num1)+Integer.parseInt(num2); 
//				break;
//			
//			case 2: 
//				sum = Integer.parseInt(num1)-Integer.parseInt(num2); 
//				break;
//			
//			case 3: 
//				sum = Integer.parseInt(num1)*Integer.parseInt(num2); 
//				break;
//			
//			case 4: 
//				sum = Integer.parseInt(num1)/Integer.parseInt(num2); 
//				break;
//			
//			case 5: 
//				sum = Integer.parseInt(num1)%Integer.parseInt(num2); 
//				break;
//			
//			default: break;
//		}
//		log.debug("num1={}, num2={}, operatr={}, sum={}", num1, num2, operatr, sum);
//		
//		return "redirect:/ex/calc1Result?sum="+sum;
//	}
//	
//	@GetMapping("calc1Result")
//	public String calculationResult1(@RequestParam("sum")int sum, Model model) {
//		
//		model.addAttribute("sum", sum);
//		return "redirect:/ex/calc1Result";
//	}
	
	@GetMapping("calc2")
	public String calc2() {
		return "ex/calc2";
	}
	
	@PostMapping("calc2")
	public String calculation2(
			@ModelAttribute CalcDTO dto,
			Model model) {
		int res = 0;
		try {
			res =calcService.calc(dto);
			model.addAttribute("calc", dto);
			model.addAttribute("sum", res);
		}catch(Exception e) {
			e.printStackTrace();
			return "ex/calc2";
		}
		
		return "ex/calc2Result";
	}
	
}
