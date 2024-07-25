package net.datasa.web4.memo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import net.datasa.web4.memo.dto.DeleteMemoReqDto;
import net.datasa.web4.memo.dto.GetMemoReqDto;
import net.datasa.web4.memo.dto.GetMemoResDto;
import net.datasa.web4.memo.dto.RegistMemoReqDto;
import net.datasa.web4.memo.entity.MemoEntity;
import net.datasa.web4.memo.repository.MemoRepository;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemoService {
	
	private final MemoRepository memoRepository;
	
	@Transactional(readOnly = true)
	public GetMemoResDto getMemo(GetMemoReqDto dto) {
		MemoEntity memo = memoRepository.findById(dto.getId())
				.orElseThrow(()-> new NoSuchElementException());
		
		GetMemoResDto resDto = GetMemoResDto.builder()
				.id(memo.getId())
				.name(memo.getName())
				.contents(memo.getContents())
				.createdTime(memo.getCreatedTime()).build();
		
		return resDto;
	}
	
	@Transactional(readOnly = true)
	public Page<GetMemoResDto> getMemos(Pageable pageable){
		int page = pageable.getPageNumber()-1;
		int pageLimit = 10;
		
		Page<MemoEntity> memos = memoRepository.findAll(PageRequest.of(page, pageLimit, Sort.by(Sort.Direction.DESC, "id")));
//		List<GetMemoResDto> dtos = new ArrayList<>();
//		for(MemoEntity memo : memos) {
//			GetMemoResDto dto = GetMemoResDto.builder()
//					.id(memo.getId())
//					.name(memo.getName())
//					.contents(memo.getContents())
//					.createdTime(memo.getCreatedTime()).build();
//			dtos.add(dto);
//		}
		
		Page<GetMemoResDto> dtos = memos.map(
				memo -> GetMemoResDto.builder()
				.id(memo.getId())
				.name(memo.getName())
				.contents(memo.getContents())
				.createdTime(memo.getCreatedTime()).build());
		log.debug("total page={}", dtos.getTotalPages());
		return dtos;
		
	}
	
	@Transactional
	public void registMemo(RegistMemoReqDto dto) {
		MemoEntity memo = MemoEntity.builder()
				.name(dto.getName()) 
				.pw(dto.getPw())
				.contents(dto.getContents()).build();
		
		memoRepository.save(memo);
	}
	
	@Transactional
	public void deleteMemo(DeleteMemoReqDto dto) {
		
		MemoEntity memo = memoRepository.findById(dto.getId())
				.orElseThrow(()-> new NoSuchElementException());
		
		if(memo.getPw().equals(dto.getPw())){
			memoRepository.deleteById(dto.getId());
		} else {
			throw new IllegalArgumentException("비밀번호가 일치하지 않음");
		}
	}
}
