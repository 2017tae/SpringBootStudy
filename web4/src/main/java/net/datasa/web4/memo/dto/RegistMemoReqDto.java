package net.datasa.web4.memo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class RegistMemoReqDto {
	
	private String name;
	private String pw;
	private String contents;
	
	@Builder
	public RegistMemoReqDto(String name, String pw, String contents) {
		this.name = name;
		this.pw = pw;
		this.contents = contents;
	}

}
