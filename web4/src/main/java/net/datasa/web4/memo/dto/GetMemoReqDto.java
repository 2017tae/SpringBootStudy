package net.datasa.web4.memo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMemoReqDto {
	
	private int id;
	
	@Builder
	public GetMemoReqDto(int id) {
		this.id = id;
	}
}
