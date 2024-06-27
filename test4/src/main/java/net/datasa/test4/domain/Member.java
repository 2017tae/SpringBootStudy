package net.datasa.test4.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Member {
	String id;
	String pw;
	String name;
	String phoneNum;
	String com;

	@Builder
	public Member(String id, String pw, String name, String phoneNum, String com) {
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.phoneNum = phoneNum;
		this.com = com;
	}
}
