package net.datasa.web5.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class WriteBoardDTO {
	
	private String memberId;
	private String title;
	private String contents;
	private String originalName;
	
	@Builder
	WriteBoardDTO(String memberId, String title, String contents, String originalName){
		this.memberId = memberId;
		this.title = title;
		this.contents = contents;
		this.originalName = originalName;
	}
}
