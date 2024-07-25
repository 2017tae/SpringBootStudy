package net.datasa.web5.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class LoginMemberDTO {
	
	private String memberId;
	private String memberPassword;
	
	@Builder
	LoginMemberDTO(String memberId, String memberPassword){
		this.memberId = memberId;
		this.memberPassword = memberPassword;
	}
	
}
