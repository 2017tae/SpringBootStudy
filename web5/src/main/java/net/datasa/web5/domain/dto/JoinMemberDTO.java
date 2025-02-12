package net.datasa.web5.domain.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.datasa.web5.domain.entity.Role;

@Getter
@NoArgsConstructor
public class JoinMemberDTO {
	
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String email;
	private String phone;
	private String address;
	private boolean enabled;
	private Role role;
	
	@Builder
	JoinMemberDTO(String memberId, String memberPassword,String memberName, String email, String phone, String address, boolean enabled, Role role){
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.enabled = enabled;
		this.role =role;
	}
	
}
