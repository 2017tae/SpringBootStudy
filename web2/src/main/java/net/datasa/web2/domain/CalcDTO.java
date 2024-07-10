package net.datasa.web2.domain;

import lombok.Data;

/**
 * 계산 데이터 DTO
 */

@Data
public class CalcDTO {
	int num1;
	String op;
	int num2;
}
