package net.datasa.web5.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.web5.domain.dto.WriteBoardDTO;
import net.datasa.web5.domain.entity.Board;
import net.datasa.web5.domain.entity.Member;
import net.datasa.web5.repository.BoardRepository;
import net.datasa.web5.repository.MemberRepository;

@Service
@Slf4j
@RequiredArgsConstructor
public class BoardService {
	
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	
	@Transactional
	public void write(WriteBoardDTO dto) {
		
		Member member = memberRepository.findById(dto.getMemberId())
				.orElseThrow(()-> new NoSuchFieldError("해당 아이디는 없는 아이디입니다."));
		
		Board board = Board.builder()
				.title(dto.getTitle())
				.contents(dto.getContents())
				.originalName(dto.getOriginalName())
				.fileName("")
				.member(member).build();
		boardRepository.save(board);
		
	}
}
