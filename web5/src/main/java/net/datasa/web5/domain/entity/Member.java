package net.datasa.web5.domain.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web5_member")
@Getter
@NoArgsConstructor
public class Member {
	
	@Id
	@Column(name="member_id", nullable=false, length=30)
	private String memberId;
	
	@Column(name="member_password", nullable=false, length=100)
	private String memberPassword;
	
	@Column(name="member_name", nullable=false, length=30)
	private String memberName;
	
	@Column(name="email", length = 50)
	private String email;
	
	@Column(name="phone", length = 30)
	private String phone;
	
	@Column(name="address", length = 200)
	private String address;
	
	@Column(name="enabled", columnDefinition="default=1")
	private boolean enabled;
	
	@Column(name="role", columnDefinition="default=`ROLE_USER`")
	@Enumerated(EnumType.STRING)
	private Role role;
	
	@Builder
	Member(String memberId, String memberPassword, String memberName, String email, String phone, String address, boolean enabled, Role role){
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.role = role;
		this.enabled = enabled;
	}
	
	public void updateMemberInfo(String memberPassword, String memberName, String email, String phone, String address) {
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	
}
