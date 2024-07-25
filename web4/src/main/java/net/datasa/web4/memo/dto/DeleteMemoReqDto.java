package net.datasa.web4.memo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class DeleteMemoReqDto {
	
	private int id;
	private String pw;
	
	@Builder
	public DeleteMemoReqDto(int id, String pw) {
		this.id = id;
		this.pw = pw;
	}
}
