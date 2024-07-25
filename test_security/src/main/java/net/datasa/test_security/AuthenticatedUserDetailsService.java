package net.datasa.test_security;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Service
@RequiredArgsConstructor
@Slf4j
public class AuthenticatedUserDetailsService implements UserDetailsService{
	
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//전달받은 사용자 아이디(username)으로 DB에서 사용자 정보 조회
		//아이디가 없으면 예외
		//있으면 조회된 정보로 UserDetails객체 생성해서 리턴
		
		AuthenticatedUser user = AuthenticatedUser.builder()
				.id("abc")
				.password(bCryptPasswordEncoder.encode("123"))
				.name("홍길동")
				.roleName("ROLE_USER")
				.enabled(true).build();
		
		log.debug("user={}", user);
		return user;
	}
	
}
