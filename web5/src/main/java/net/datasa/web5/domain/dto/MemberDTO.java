package net.datasa.web5.domain.dto;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.datasa.web5.domain.entity.Role;

@Getter
@NoArgsConstructor
@Data
public class MemberDTO implements UserDetails{
	
	private String memberId;
	private String memberPassword;
	private String memberName;
	private String email;
	private String phone;
	private String address;
	private boolean enabled;
	private Role role; 
	
	@Builder
	MemberDTO(String memberId, String memberPassword, String memberName, String email, String phone, String address, boolean enabled, Role role){
		this.memberId = memberId;
		this.memberPassword = memberPassword;
		this.memberName = memberName;
		this.email = email;
		this.phone = phone;
		this.address = address;
		this.enabled = enabled;
		this.role =role;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(role.getRole()));
	}

	@Override
	public String getPassword() {
		return memberPassword;
	}

	@Override
	public String getUsername() {
		return memberId;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	//정상 아이디인지 여부
	@Override
	public boolean isEnabled() {
		return enabled;
	}
	
}
