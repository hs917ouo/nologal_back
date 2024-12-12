package com.hs917ouo.nologal.mapper;

import com.hs917ouo.nologal.dto.PostDTO;
import com.hs917ouo.nologal.entity.Post;

public class PostMapper {

	public static PostDTO toDTO(Post post) {
		return PostDTO.builder()
			.id(post.getId())
			.title(post.getTitle())
			.body(post.getBody())
			.nickname(post.getNickname())
			.password(post.getPassword())
			.createdAt(post.getCreateAt())
			.updatedAt(post.getUpdateAt())
			.build();
	}
}
