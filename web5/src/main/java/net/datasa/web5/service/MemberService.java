package net.datasa.web5.service;

import java.util.NoSuchElementException;

import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.web5.domain.dto.JoinMemberDTO;
import net.datasa.web5.domain.dto.LoginMemberDTO;
import net.datasa.web5.domain.dto.MemberDTO;
import net.datasa.web5.domain.entity.Member;
import net.datasa.web5.domain.entity.Role;
import net.datasa.web5.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class MemberService implements UserDetailsService{
	
	private final MemberRepository memberRepository;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	
	/**
	 * ID 중복 체크
	 * 중복된 경우 예외 처리
	 * @param id
	 */
	@Transactional(readOnly = true)
	public void duplicateCheck(String id) {
		if(memberRepository.existsById(id)) {
			throw new DuplicateKeyException("중복된 아이디");
		}
	}
	
	/**
	 * 회원가입 로직
	 * dto를 entity로 변환 후 저장
	 * @param dto
	 */
	@Transactional
	public void join(JoinMemberDTO dto) {
		
		duplicateCheck(dto.getMemberId());
		
		Member member = Member.builder()
				.memberId(dto.getMemberId())
				.memberName(dto.getMemberName())
				.memberPassword(bCryptPasswordEncoder.encode(dto.getMemberPassword()))
				.email(dto.getEmail())
				.phone(dto.getPhone())
				.address(dto.getAddress())
				.enabled(true)
				.role(Role.ROLE_USER).build();
		
		memberRepository.save(member);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		
		Member member = memberRepository.findById(username)
				.orElseThrow(()-> new NoSuchElementException("해당 아이디는 존재하지 않습니다."));
		
		MemberDTO user = MemberDTO.builder()
				.memberId(member.getMemberId())
				.memberPassword(member.getMemberPassword())
				.memberName(member.getMemberName())
				.email(member.getEmail())
				.phone(member.getPhone())
				.address(member.getAddress())
				.role(member.getRole())
				.enabled(member.isEnabled()).build();
		
		log.debug("user={}", user);
		return user;
	}
}
