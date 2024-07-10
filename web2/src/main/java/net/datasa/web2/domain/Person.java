package net.datasa.web2.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

//@Data
@Setter
@Getter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
	String name;
	int age;
	String phone;
}
