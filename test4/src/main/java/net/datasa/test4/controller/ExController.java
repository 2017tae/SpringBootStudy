package net.datasa.test4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
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
	public String calc1(@CookieValue(name="cnt", defaultValue="0")int num, HttpServletResponse res) {
		
		Cookie nCnt = new Cookie("cnt", Integer.toString(++num));
		nCnt.setPath("/");
		nCnt.setMaxAge(60*60*24*3);
		
		log.debug("cnt:{}", num);
		res.addCookie(nCnt);
		
		return "ex/calc1";
	}

	@PostMapping("calc1")
	public String calculation1(@RequestParam("num1") int num1, @RequestParam("num2") int num2,
			@RequestParam("operator") int operatr, Model model) {

		int sum = 0;
		try {
			switch (operatr) {
			case 1:
				sum = num1 + num2;
				break;

			case 2:
				sum = num1 - num2;
				break;

			case 3:
				sum = num1 * num2;
				break;

			case 4:
				sum = num1 / num2;
				break;

			case 5:
				sum = num1 % num2;
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
		return "ex/calc1Result";
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
	public String calc2(@CookieValue(name="cnt", defaultValue="0")int num, HttpServletResponse res) {
		Cookie nCnt = new Cookie("cnt", Integer.toString(++num));
		nCnt.setPath("/");
		nCnt.setMaxAge(60*60*24*3);
		
		log.debug("cnt:{}", num);
		res.addCookie(nCnt);
		
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
	
	/**
	 * 방문자의 방문 횟수를 카운트하고 수정,
	 * @param count 과거 방문 횟수, 없으면 0으로 처리
	 * @param response 클라이언트로의 응답객체
	 * @param model HTML로 전달할 값들을 저장할 객체
	 * @return HTML 템플릿 파일의 경로
	 */
	@GetMapping("count")
	public String count(
			@CookieValue(name="cnt", defaultValue="0")int count, 
			HttpServletResponse response,
			Model model) {
		
		Cookie nCnt = new Cookie("cnt", Integer.toString(++count));
		nCnt.setPath("/");
		nCnt.setMaxAge(60*60*24*3);
		
		log.debug("cnt:{}", count);
		response.addCookie(nCnt);
		model.addAttribute("msg", "첫 방문을 환영합니다.");
		model.addAttribute("msg", count+"번째 방문을 축하드립니다");
		return "ex/count";
	}
	
	/**
	 * 첫 방문자의 닉네임을 입력받아 쿠키에 저장
	 */
	@GetMapping("count2")
	public String count2(
			@CookieValue(name="count2", defaultValue = "0") int count2,
			@CookieValue(name="name", defaultValue = "") String name,
			HttpServletResponse response,
			Model model) {
		
		if (name == null || name.isEmpty()) {
			return "ex/inputName";
		}
		
		count2++;
		model.addAttribute("count2", count2);
		model.addAttribute("name", name);
		
		Cookie ck = new Cookie("count2", Integer.toString(count2));
		ck.setMaxAge(60*60*24*365);
		response.addCookie(ck);
		
		return "ex/count2";
	}

	/**
	 * 첫 방문자에게 닉네임 입력받기
	 */
	@GetMapping("inputName")
	public String inputName() {
		return "ex/inputName";
	}
	
	/**
	 * 닉네임을 쿠키에 저장
	 */
	@PostMapping("inputName")
	public String inputName(
			@RequestParam("name") String name,
			HttpServletResponse response) {
		Cookie ck = new Cookie("name", name);
		ck.setMaxAge(60*60*24*365);
		response.addCookie(ck);
		return "redirect:count2";
	}

}
