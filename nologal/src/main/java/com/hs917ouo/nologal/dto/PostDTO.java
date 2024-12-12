package com.hs917ouo.nologal.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostDTO {
	private Long id;
	private LocalDateTime createdAt, updatedAt;
	private String title, body, nickname, password;
}
