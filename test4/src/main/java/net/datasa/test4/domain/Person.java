package net.datasa.test4.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class Person {
	String name;
	int age;
	String phoneNum;
	
	@Builder
	public Person(String name, int age, String phoneNum) {
		this.name =name;
		this.age = age;
		this.phoneNum = phoneNum;
	}
	
}
