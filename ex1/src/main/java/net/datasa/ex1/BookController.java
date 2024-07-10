package net.datasa.ex1;

import java.time.LocalDate;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Controller
@RequestMapping("book")
@RequiredArgsConstructor
@Slf4j
public class BookController {
	
	private final BookService bookService;
	
	/**
	 * 책을 등록하는 페이지
	 * @return	출력할 페이지의 파일 경로
	 */
	@GetMapping("regist")
	public String registView() {
		return "regist";
	}
	
	/**
	 * 책을 검색하는 페이지
	 * @return 	출력할 페이지의 파일 경로
	 */
	@GetMapping("search")
	public String searchView() {
		return "search";
	}
	
	/**
	 * 책의 정보를 입력하고 등록
	 * @param isbn		책의 pk
	 * @param title		책의 제목
	 * @param writer	책의 작가
	 * @param publisher	책의 출판사
	 * @param date		책의 출판날짜
	 * @param price		책의 가격
	 * @param discount	책의 할인율
	 * @return			redirect
	 */
	@PostMapping("regist")
	public String registBook(
			@RequestParam(name="isbn")String isbn,
			@RequestParam(name="title")String title,
			@RequestParam(name="writer")String writer,
			@RequestParam(name="publisher")String publisher,
			@RequestParam(name="publishDate")LocalDate date,
			@RequestParam(name="price")int price,
			@RequestParam(name="discount")double discount) {
		BookDTO dto = BookDTO.builder()
				.isbn(isbn)
				.title(title)
				.writer(writer)
				.publisher(publisher)
				.publishDate(date)
				.price(price)
				.discount(discount).build();
		log.debug("date={}", date);
		try {
			bookService.registBook(dto);
			return "redirect:/";
		}catch(Exception e) {
			e.printStackTrace();
			return "error";
		}
		
	}
	
	/**
	 * 책 정보를 불러오고 책 정보 페이지로 이동
	 * @param isbn	불러올 책의 pk
	 * @param model	Controller에서 View로 데이터를 이동할 객체
	 * @return		출력할 HTML 파일 경로
	 */
	@GetMapping("info")
	public String getBookInfo(
			@RequestParam(name = "isbn")String isbn, Model model) {
		BookInfoReqDTO dto = BookInfoReqDTO.builder().isbn(isbn).build();
		try {
			BookInfoResDTO resDto = bookService.getBook(dto);
			log.debug("date={}", resDto.getPublishDate());
			model.addAttribute("isbn", resDto.getIsbn());
			model.addAttribute("title", resDto.getTitle());
			model.addAttribute("writer", resDto.getWriter());
			model.addAttribute("publisher", resDto.getPublisher());
			model.addAttribute("publishDate", resDto.getPublishDate());
			model.addAttribute("discount", resDto.getDiscount());
			model.addAttribute("beforePrice", resDto.getBeforePrice());
			model.addAttribute("curPrice", resDto.getCurPrice());
		}catch(Exception e) {
			model.addAttribute("err", "해당 책은 존재하지 않습니다.");
		}
		return "info";
	}
	
	/**
	 * 책의 저장 여부를 확인하고 삭제
	 * @param isbn	삭제할 책의 pk
	 * @return		redirect
	 */
	@PostMapping("delete")
	public String deleteBook(@RequestParam(name="isbn")String isbn) {
		log.debug("isbn={}", isbn);
		BookInfoReqDTO dto = BookInfoReqDTO.builder().isbn(isbn).build();
		try {
			bookService.deleteBook(dto);
			return "redirect:/";	
		}catch(Exception e) {
			return "error";
		}
		
	}
	
}
