package net.datasa.web5.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class GetMemberDTO {
	private String memberId;
	private String memberName;
	private String email;
	private String phone;
	private String address;
	
	@Builder
	GetMemberDTO(String memberId, String memberName, String email, String phone, String address){
		this.memberId = memberId;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
}
