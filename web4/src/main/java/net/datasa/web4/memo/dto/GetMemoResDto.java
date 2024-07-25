package net.datasa.web4.memo.dto;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
public class GetMemoResDto {
	
	private int id;
	private String name;
	private String contents;
	private LocalDateTime createdTime;
	
	@Builder
	public GetMemoResDto(int id, String name, String contents, LocalDateTime createdTime) {
		this.id=id;
		this.name = name;
		this.contents = contents;
		this.createdTime = createdTime;
	}
}
