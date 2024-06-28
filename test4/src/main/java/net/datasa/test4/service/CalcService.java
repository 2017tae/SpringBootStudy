package net.datasa.test4.service;

import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;
import net.datasa.test4.domain.CalcDTO;

@Service
@Slf4j
public class CalcService {
	public int calc(CalcDTO dto) throws Exception {
		int res = 0;
		switch (dto.getOperatr()) {
		case "+":
			res = dto.getNum1() + dto.getNum2();
			break;
		case "-":
			res = dto.getNum1() - dto.getNum2();
			break;
		case "*":
			res = dto.getNum1() * dto.getNum2();
			break;
		case "/":
			res = dto.getNum1() / dto.getNum2();
			break;
		default:
			throw new Exception("연산자 오류");
		}
		
		return res;
	}
}
