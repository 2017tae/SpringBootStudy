package net.datasa.web2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//가입할 때 ID, 비번, 이름, 전화, 통신사를 모두 저장할 DTO클래스
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Member {
	//FORM의 name과 일치하게 변수 선언
	String id;
	String pw;
	String name;
	String phone;
	String com;
}
