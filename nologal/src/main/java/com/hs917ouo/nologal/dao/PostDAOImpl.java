package com.hs917ouo.nologal.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.hs917ouo.nologal.dto.PostDTO;
import com.hs917ouo.nologal.entity.Post;
import com.hs917ouo.nologal.mapper.PostMapper;
import com.hs917ouo.nologal.repository.PostRepository;

@Component
public class PostDAOImpl implements PostDAO {

	private final PostRepository postRepository;

	public PostDAOImpl(PostRepository postRepository) {
		this.postRepository = postRepository;
	}

	@Override
	public List<PostDTO> getAllPosts() {
		return postRepository.findAll().stream().map(PostMapper::toDTO).toList();
	}

	@Override
	public Optional<PostDTO> getPostById(Long id) {
		return postRepository.findById(id).map(PostMapper::toDTO);
	}

	@Override
	public List<PostDTO> getPostsByNickname(String nickname) {
		return postRepository.findByNickname(nickname).stream().map(PostMapper::toDTO).toList();
	}

	@Override
	public List<PostDTO> getPostsByKeyword(String keyword) {
		return postRepository.findByKeyword(keyword).stream().map(PostMapper::toDTO).toList();
	}

	@Override
	public PostDTO insertPost(PostDTO postDTO) {
		Post post = new Post();
		post.setTitle(postDTO.getTitle());
		post.setNickname(postDTO.getNickname());
		post.setPassword(postDTO.getPassword());
		post.setBody(postDTO.getBody());
		Post savedPost = postRepository.save(post);
		return PostMapper.toDTO(savedPost);
	}

	@Override
	public PostDTO updatePost(PostDTO postDTO) {
		Post post = postRepository.findById(postDTO.getId()).orElseThrow();
		post.setTitle(postDTO.getTitle());
		post.setBody(postDTO.getBody());
		Post savedPost = postRepository.save(post);
		return PostMapper.toDTO(savedPost);
	}

	@Override
	public void deletePost(Long id) {
		postRepository.deleteById(id);
	}
}
