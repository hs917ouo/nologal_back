package com.hs917ouo.nologal.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hs917ouo.nologal.dto.PostDTO;

@Service
public interface PostService {
	public PostDTO addPost(PostDTO postDTO);

	public List<PostDTO> getPosts(String nickname, String keyword);

	public PostDTO getPost(Long id) throws Exception;

	public PostDTO updatePost(Long id, PostDTO postDTO) throws Exception;

	public void deletePost(Long id) throws Exception;
}
