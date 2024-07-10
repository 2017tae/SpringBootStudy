package net.datasa.ex1;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookInfoResDTO {

	private String isbn;
	
	private String title;
	
	private String writer;
	
	private String publisher;
	
	private LocalDate publishDate;
	
	private int beforePrice;
	
	private int curPrice;
	
	private double discount;
	
	@Builder
	public BookInfoResDTO(String isbn, String title, String writer, String publisher, LocalDate publishDate, int curPrice, int beforePrice, double discount){
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.curPrice = curPrice;
		this.beforePrice = beforePrice;
		this.discount = discount;
	}
}
