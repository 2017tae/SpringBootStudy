package net.datasa.web3;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PersonDTO {
	private String ID;
	private String name;
	private int age;

	@Builder
	PersonDTO(String ID, String name, int age){
		this.ID = ID;
		this.name = name;
		this.age = age;
	}
}
