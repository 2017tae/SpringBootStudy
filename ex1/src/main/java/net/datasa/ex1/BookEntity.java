package net.datasa.ex1;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
@Table(name="book")
public class BookEntity {
	
	@Id
	@Column(name = "ISBN", nullable = false, length=20)
	private String isbn;
	
	@Column(name = "title", nullable = false, length=200)
	private String title;
	
	@Column(name = "writer", nullable = false, length=100)
	private String writer;
	
	@Column(name = "publisher", nullable = false, length=100)
	private String publisher;
	
	@Column(name = "publish_date")
	private LocalDate publishDate;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "discount")
	private double discount;
	
	@Builder
	BookEntity(String isbn, String title, String writer, String publisher, LocalDate publishDate, int price, double discount){
		this.isbn = isbn;
		this.title = title;
		this.writer = writer;
		this.publisher = publisher;
		this.publishDate = publishDate;
		this.price = price;
		this.discount = discount;
	}
}
