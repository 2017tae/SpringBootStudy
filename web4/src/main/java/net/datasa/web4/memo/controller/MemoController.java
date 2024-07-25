package net.datasa.web4.memo.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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
import net.datasa.web4.memo.dto.DeleteMemoReqDto;
import net.datasa.web4.memo.dto.GetMemoReqDto;
import net.datasa.web4.memo.dto.GetMemoResDto;
import net.datasa.web4.memo.dto.RegistMemoReqDto;
import net.datasa.web4.memo.repository.MemoRepository;
import net.datasa.web4.memo.service.MemoService;

@Controller
@RequestMapping("memo")
@Slf4j
@RequiredArgsConstructor
public class MemoController {
	
	private final MemoService memoService;
	
	@GetMapping("")
	public String memos(@PageableDefault(page = 1) Pageable pageable, Model model) {
		Page<GetMemoResDto> memos = memoService.getMemos(pageable);
		model.addAttribute("memos", memos);
		return "memoView/memoList";
	}

	@GetMapping("info")
	public String memo(@RequestParam("id") int id, Model model) {
		GetMemoReqDto reqDto = GetMemoReqDto.builder().id(id).build();
		GetMemoResDto memo = memoService.getMemo(reqDto);
		model.addAttribute("memo", memo);
		
		return "memoView/memo";
	}

	@PostMapping("regist")
	public String registMemo(@RequestParam("name") String name, 
			@RequestParam("pw") String pw,
			@RequestParam("contents") String contents, 
			Model model) {
		try {
			log.debug("{}", name);
			RegistMemoReqDto dto = RegistMemoReqDto.builder()
					.name(name)
					.pw(pw)
					.contents(contents).build();
				
			memoService.registMemo(dto);
			return "redirect:/";
		} catch (Exception e) {
			model.addAttribute("err", "등록에 실패했습니다.");
			return "memoView/writeMemo";
		}
	}

	@GetMapping("write")
	public String writeMemo() {
		return "memoView/writeMemo";
	}
	
	@GetMapping("delete")
	public String delete(@RequestParam("id")int id) {
		return "memoView/deleteMemo";
	}


	@PostMapping("delete")
	public String deleteMemo(@RequestParam("id") int id, 
			@RequestParam("pw") String pw, Model model, RedirectAttributes rttr) {
		try {
			log.debug("pw{}",pw);
			log.debug("id{}",id);
			DeleteMemoReqDto dto = DeleteMemoReqDto.builder()
					.id(id)
					.pw(pw).build();
			memoService.deleteMemo(dto);
			return "redirect:/";
		} catch (Exception e) {
			rttr.addFlashAttribute("err", "삭제에 실패했습니다");
			return "redirect:/memo/delete?id="+id;
		}
	}
}
