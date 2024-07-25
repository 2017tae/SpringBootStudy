package net.datasa.test_security;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Getter
@NoArgsConstructor
@Data
public class AuthenticatedUser implements UserDetails{
	
	//직렬화 (해당 객체인지 확인을 위하여)
	private static final long serialVersionUID=-2757275378661085190L;
	
	
	// 인증 관련 정보
	String id;
	String password;
	String name;
	String roleName;
	boolean enabled;
	
	@Builder
	AuthenticatedUser(String id, String password, String name, String roleName, boolean enabled){
		this.id = id;
		this.password = password;
		this.name = name;
		this.roleName = roleName;
		this.enabled = enabled;
	}
	
	//권한명 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Collections.singletonList(new SimpleGrantedAuthority(roleName));
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return id;
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
