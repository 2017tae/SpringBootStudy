package net.datasa.web5.domain.entity;

import lombok.Getter;

@Getter
public enum Role {
	ROLE_USER("ROLE_USER"),
	ROLE_ADMIN("ROLE_ADMIN");
	
	private String role;
	
	Role(String role){
		this.role = role;
	}
}
