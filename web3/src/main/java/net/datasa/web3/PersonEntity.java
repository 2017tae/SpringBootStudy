package net.datasa.web3;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

/**
 * DB의 테이블과 매핑되는 클래스
 */

@Entity
@Getter
@NoArgsConstructor
@Table(name = "person") // 어느 테이블과 매칭되는지 특정
public class PersonEntity {

	@Id
	@Column(name = "id", nullable = false, length = 30)
	private String id;

	@Column(name = "name", length = 50)
	private String name;

	@Column(name = "age")
	private int age;

	@Builder
	public PersonEntity(String id, String name, int age) {
		this.id = id;
		this.name = name;
		this.age = age;
	}
}
