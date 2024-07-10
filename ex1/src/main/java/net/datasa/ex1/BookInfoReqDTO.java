package net.datasa.ex1;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class BookInfoReqDTO {

	private String isbn;

	@Builder
	public BookInfoReqDTO(String isbn) {
		this.isbn = isbn;
	}
}
