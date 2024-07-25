package net.datasa.web4.memo.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="memo")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class MemoEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="name", nullable=false, length=100)
	private String name;
	
	@Column(name="pw", nullable=false, length=100)
	private String pw;
	
	@Column(name="contents", nullable=false)
	private String contents;
	
	@Column(name="created_time")
	@CreatedDate
	private LocalDateTime createdTime;
	
	@Builder
	public MemoEntity(String name, String pw, String contents) {
		this.name = name;
		this.pw = pw;
		this.contents = contents;
	}
}
