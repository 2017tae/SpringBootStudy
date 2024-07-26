package net.datasa.web5.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class UpdateMemberDTO {
	
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String email;
	private String phone;
	private String address;
	
	@Builder
	UpdateMemberDTO(String memberId, String memberPassword, String memberName, String email, String phone, String address){
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
}
