package net.datasa.web5.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.web5.domain.dto.JoinMemberDTO;
import net.datasa.web5.domain.dto.LoginMemberDTO;
import net.datasa.web5.service.MemberService;

/**
 * 회원정보관련 Controller
 */
@Slf4j
@Controller
@RequestMapping("member")
@RequiredArgsConstructor
public class MemberController {
	
	private final MemberService memberService;
	
	/**
	 * 로그인 화면을 불러옴
	 * @return
	 */
	@GetMapping("loginForm")
	public String loginForm() {
		return "memberView/loginForm";
	}
	
//	/**
//	 * 로그인 로직을 처리함
//	 * @return 홈으로 redirect
//	 */
//	@PostMapping("login")
//	public String login(@RequestParam(name="id")String id,
//			@RequestParam(name="pw")String pw,
//			RedirectAttributes redirectAttr) {
//		try {
//			LoginMemberDTO dto = LoginMemberDTO.builder()
//					.memberId(id)
//					.memberPassword(pw).build();
//			memberService.login(dto);
//		}catch(Exception e) {
//			redirectAttr.addFlashAttribute("err", e.getMessage());
//			return "redirect:/member/loginForm";
//		}
//		return "redirect:/";
//	}
//	
	/**
	 * 회원가입 화면을 불러옴
	 * @return
	 */
	@GetMapping("joinForm")
	public String joinForm() {
		return "memberView/joinForm";
	}
	
	/**
	 * 아이디 중복 체크 화면을 불러옴
	 * @return
	 */
	@GetMapping("idCheckForm")
	public String idCheckForm() {
		return "memberView/idCheckForm";
	}
	
	@PostMapping("idCheckForm")
	public String idCheck(@RequestParam(name="id")String id, Model model) {
		try {
			memberService.duplicateCheck(id);
			model.addAttribute("checkedId", id);
		}catch(Exception e) {
			model.addAttribute("err", e.getMessage());
		}
		return "memberView/idCheckForm";
	}
	
	
	/**
	 * 회원가입을 로직을 처리
	 * @return 홈으로 redirect
	 */
	@PostMapping("join")
	public String join(@RequestParam(name="id")String id,
			@RequestParam(name="pw")String pw,
			@RequestParam(name="pw1")String pw1,
			@RequestParam(name="name")String name,
			@RequestParam(name="email")String email,
			@RequestParam(name="phone")String phone,
			@RequestParam(name="address")String address,
			RedirectAttributes redirectAttr) {
		try {
			JoinMemberDTO dto = JoinMemberDTO.builder()
					.memberId(id)
					.memberPassword(pw)
					.memberPassword1(pw1)
					.memberName(name)
					.email(email)
					.phone(phone)
					.address(address).build();
			memberService.join(dto);
		}catch(Exception e) {
			redirectAttr.addFlashAttribute("err", e.getMessage());
			return "redirect:/member/joinForm";
		}
		
		return "redirect:/";
	}
	
	/**
	 * 회원정보 화면을 불러옴
	 * @return
	 */
	@GetMapping("info")
	public String infoForm() {
		return "memberView/infoForm";
	}
	
	/**
	 * 회원정보 변경 로직을 처리
	 * @return 홈으로 redirect
	 */
	@PostMapping("info")
	public String update() {
		return "redirect:/";
	}
}
