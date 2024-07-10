package net.datasa.ex1;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class BookService {

	private final BookRepository bookRepository;
	
	@Transactional
	public void registBook(BookDTO dto) {
		BookEntity book = BookEntity.builder()
				.isbn(dto.getIsbn())
				.title(dto.getTitle())
				.writer(dto.getWriter())
				.publisher(dto.getPublisher())
				.publishDate(dto.getPublishDate())
				.price(dto.getPrice())
				.discount(dto.getDiscount()).build();
		if(bookRepository.existsById(dto.getIsbn())) {
			throw new RuntimeException();
		}
		bookRepository.save(book);
	}
	
	@Transactional(readOnly = true)
	public BookInfoResDTO getBook(BookInfoReqDTO reqDto) {
		BookEntity book = bookRepository.findById(reqDto.getIsbn())
				.orElseThrow(()-> new RuntimeException());
		
		int curPrice = (int)((1-book.getDiscount())*book.getPrice());
		
		log.debug("date={}", book.getPublishDate());
		BookInfoResDTO dto = BookInfoResDTO.builder()
				.isbn(book.getIsbn())
				.title(book.getTitle())
				.writer(book.getWriter())
				.publisher(book.getPublisher())
				.publishDate(book.getPublishDate())
				.curPrice(curPrice)
				.beforePrice(book.getPrice())
				.discount(book.getDiscount()).build();
		
		return dto;
	}
	
	@Transactional
	public void deleteBook(BookInfoReqDTO reqDto) {
		if(bookRepository.existsById(reqDto.getIsbn())==false) {
			throw new RuntimeException();
		}
		bookRepository.deleteById(reqDto.getIsbn());
	}
	
}
