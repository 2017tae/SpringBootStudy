package net.datasa.web2.service;

import org.springframework.stereotype.Service;

import net.datasa.web2.domain.CalcDTO;

/**
 * 계산 관련 서비스 클래스
 */
@Service
public class CalcService {
	
	//계산 메소드
	public int calc(CalcDTO dto) throws Exception {
		int res = 0;
		
		switch (dto.getOp()) {
			case "+" : res = dto.getNum1() + dto.getNum2(); break;
			case "-" : res = dto.getNum1() - dto.getNum2(); break;
			case "*" : res = dto.getNum1() * dto.getNum2(); break;
			case "/" : res = dto.getNum1() / dto.getNum2(); break;
			default: throw new Exception("연산자 오류");
		}
		return res;
	}

}
