package net.datasa.web5.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import lombok.RequiredArgsConstructor;
import net.datasa.web5.domain.dto.AuthenticatedMember;
import net.datasa.web5.domain.dto.WriteBoardDTO;
import net.datasa.web5.service.BoardService;

@Controller
@RequestMapping("board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	
	@GetMapping("list")
	public String list() {
		return "boardView/list";
	}
	
	@GetMapping("write")
	public String writeView() {
		return "boardView/write";
	}
	
	@PostMapping("write")
	public String write(@RequestParam(name="title")String title,
			@RequestParam(name="contents")String contents,
			@RequestParam(name="originalName")String originalName,
			@AuthenticationPrincipal AuthenticatedMember member,
			RedirectAttributes redirectAttr) {
		
		try {
			WriteBoardDTO dto = WriteBoardDTO.builder()
					.title(title)
					.contents(contents)
					.originalName(originalName)
					.memberId(member.getMemberId()).build();
			boardService.write(dto);
					
		}catch(Exception e) {
			redirectAttr.addFlashAttribute("err", "에러 발생");
			return "redirect:/board/write";
		}
		return "redirect:/";
	}
}
