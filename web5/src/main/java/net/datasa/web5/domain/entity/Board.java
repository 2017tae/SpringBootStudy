package net.datasa.web5.domain.entity;

import java.time.LocalDateTime;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="web5_board")
@Getter
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Board {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="board_num")
	private int boardNum;
	
	@Column(name="title", nullable= false)
	private String title;
	
	@Column(name="contents", nullable= false)
	private String contents;
	
	@Column(name="view_count", columnDefinition="default = 0")
	private int viewCount;
	
	@Column(name="like_count", columnDefinition="default = 0")
	private int likeCount;
	
	@Column(name="original_name", columnDefinition="default = 0")
	private String originalName;
	
	@Column(name="file_name", columnDefinition="default = 0")
	private String fileName;
	
	@Column(name="create_date", columnDefinition="default = 0")
	@CreatedDate
	private LocalDateTime createDate;
	
	@Column(name="update_date", columnDefinition="default = 0")
	@LastModifiedDate
	private LocalDateTime updateDate;
	
	@ManyToOne
	@JoinColumn(name="member_id")
	private Member member;
	
	@Builder
	Board(Member member, String title, String contents, String originalName, String fileName){
		this.member = member;
		this.title = title;
		this.contents = contents;
		this.viewCount = 0;
		this.likeCount = 0;
		this.originalName = originalName;
		this.fileName = fileName;
	}
	
}
