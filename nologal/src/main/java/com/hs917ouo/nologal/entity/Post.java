package com.hs917ouo.nologal.entity;

import java.time.LocalDateTime;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.Comment;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "post")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Post {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", nullable = false, columnDefinition = "bigint unsigned")
	private Long id;

	@CreationTimestamp
	@Column(name = "createAt", nullable = false, columnDefinition = "TIMESTAMP")
	@ColumnDefault("CURRENT_TIMESTAMP")
	@Comment("등록일시")
	private LocalDateTime createAt;

	@UpdateTimestamp
	@Column(name = "updateAt", nullable = false, columnDefinition = "TIMESTAMP")
	@ColumnDefault("CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP")
	@Comment("수정일시")
	private LocalDateTime updateAt;

	@Column(name = "title", nullable = false, columnDefinition = "varchar(255)")
	@Comment("제목")
	private String title;

	@Column(name = "body", nullable = false, columnDefinition = "TEXT")
	@Comment("내용")
	private String body;

	@Column(name = "nickname", nullable = false, columnDefinition = "varchar(30)")
	@Comment("작성자")
	private String nickname;

	@Column(name = "password", nullable = false, columnDefinition = "varchar(255)")
	@Comment("비밀번호, 암호화되어 저장")
	private String password;
}
