package com.hs917ouo.nologal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hs917ouo.nologal.dto.PostDTO;

@Component
public interface PostDAO {
	public List<PostDTO> getAllPosts();

	public Optional<PostDTO> getPostById(Long id);

	public List<PostDTO> getPostsByNickname(String nickname);

	public List<PostDTO> getPostsByKeyword(String keyword);

	public PostDTO insertPost(PostDTO post);

	public PostDTO updatePost(PostDTO post);

	public void deletePost(Long id);
}
