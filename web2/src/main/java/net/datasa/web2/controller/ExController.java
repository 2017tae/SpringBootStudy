package net.datasa.web2.controller;

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
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import net.datasa.web2.domain.CalcDTO;
import net.datasa.web2.service.CalcService;

/**
 * 연습문제
 * 클래스에 대한 설명, 최초 작성일, 작성자, 수정일, 수정한 내용
 */
@Slf4j
@RequestMapping("/ex")
@Controller
public class ExController {
	
	/**
	 * 필요한 객체를 타입으로 찾아서 주입
	 * 계산기 관련 기능 서비스
	 */
	@Autowired
	CalcService calcService;

	
	/**
	[연습문제 1]
	1. ex/calc1 경로로 요청
	2. 입력 폼을 출력 (입력란 2개, Select 1개, submit버튼 1개 포함)
	3. 숫자 2개를 입력하고 연산자를 선택 후 submit 버튼 클릭
	4. 숫자가 아닌 값을 입력하면 JavaScript로 확인하고 오류메시지 출력
	5. 숫자 2개를 정상적으로 입력하면 서버로 전송
	6. 콘트롤러에서 값을 전달받아 계산
	7. 계산한 결과를 Model에 저장하고 View로 이동
	8. 화면에 계산한 결과 출력
	(새로운 Controller 정의, HTML 파일 2개 필요)
	 */
	
	/**
	 * 계산기 폼 화면으로 이동
	 */
	@GetMapping("calc1")
	public String calc1() {
		return "exView/calcForm1";
	}


	@PostMapping("calc1")
	public String calcOutput1(
			@ModelAttribute CalcDTO dto,
			Model model) {

		int res = 0;
		try {
			switch (dto.getOp()) {
				case "+" : res = dto.getNum1() + dto.getNum2(); break;
				case "-" : res = dto.getNum1() - dto.getNum2(); break;
				case "*" : res = dto.getNum1() * dto.getNum2(); break;
				case "/" : res = dto.getNum1() / dto.getNum2(); break;
				default: throw new Exception("연산자 오류");
			}
			model.addAttribute("calc", dto);
			model.addAttribute("res", res);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "/exview/calcForm1";	//예외 발생시 계산폼으로 다시 이동
		}
		
		return "exView/calcOutput1";
	}
	
	/**
	 * 계산기2 폼 화면으로 이동
	 */
	@GetMapping("calc2")
	public String calc2() {
		return "exView/calcForm2";
	}


	@PostMapping("calc2")
	public String calcOutput2(
			@ModelAttribute CalcDTO dto,
			Model model) {

		//전달받은 값을 서비스로 전달
		//서비스가 리턴한 값을 모델에 저장하고 포워딩
		int res = 0;
		try {
			res = calcService.calc(dto);
			model.addAttribute("calc", dto);
			model.addAttribute("res", res);
		}
		catch (Exception e) {
			e.printStackTrace();
			return "/exview/calcForm1";	//예외 발생시 계산폼으로 다시 이동
		}
		
		return "exView/calcOutput2";
	}
	
	
	/**
	 * 방문자의 방문 횟수를 카운트하고 수정.
	 * 
	 * @param count 과거 방문 횟수. 없으면 0으로 처리.
	 * @param response 클라이언트로의 응답 객체
	 * @param model HTML로 전달할 값들을 저장할 객체
	 * @return HTML 템플릿 파일의 경로
	 */
	@GetMapping("count")
	public String count(
			@CookieValue(name="count", defaultValue = "0") int count,
			HttpServletResponse response,
			Model model) {
		//숫자가 저장된 쿠키를 읽고 없으면 0으로 처리
		//카운트 1 증가
		count++;
		//메시지를 모델에 저장
		if (count == 1) {
			model.addAttribute("msg", "첫 방문을 환영합니다.");
		}
		else {
			model.addAttribute("msg", count + "번째 방문입니다.");
		}
		//쿠키를 저장
		Cookie ck = new Cookie("count", Integer.toString(count));
		ck.setMaxAge(60*60*24*365);
		response.addCookie(ck);
		//html로 포워딩
		return "exView/count";
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
			return "exView/inputName";
		}
		
		count2++;
		model.addAttribute("count2", count2);
		model.addAttribute("name", name);
		
		Cookie ck = new Cookie("count2", Integer.toString(count2));
		ck.setMaxAge(60*60*24*365);
		response.addCookie(ck);
		
		return "exView/count2";
	}
	
	/**
	 * 첫 방문자에게 닉네임 입력받기
	 */
	@GetMapping("inputName")
	public String inputName() {
		return "exView/inputName";
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