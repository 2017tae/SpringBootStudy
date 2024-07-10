package net.datasa.ex1;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookDTO {
	
	private String isbn;
	
	private String title;
	
	private String writer;
	
	private String publisher;
	
	private LocalDate publishDate;
	
	private int price;
	
	private double discount;
	
	@Builder
	public BookDTO(String isbn, String title, String writer, String publisher, LocalDate publishDate, int price, double discount){
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publishDate = publishDate;
		this.publisher = publisher;
		this.price = price;
		this.discount = discount;
	}

}

