package com.hs917ouo.nologal.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.hs917ouo.nologal.dao.PostDAO;
import com.hs917ouo.nologal.dto.PostDTO;

@Service
public class PostServiceImpl implements PostService {

	private final PostDAO postDAO;
	private final PasswordEncoder passwordEncoder;

	public PostServiceImpl(PostDAO postDAO) {
		this.postDAO = postDAO;
		this.passwordEncoder = new BCryptPasswordEncoder();
	}

	@Override
	public PostDTO addPost(PostDTO postDTO) {
		postDTO.setPassword(passwordEncoder.encode(postDTO.getPassword()));
		PostDTO inserted = postDAO.insertPost(postDTO);
		inserted.setPassword(null);
		return inserted;
	}

	@Override
	public List<PostDTO> getPosts(String nickname, String keyword) {
		List<PostDTO> postDTOs = new ArrayList<PostDTO>();
		if (nickname == null && keyword == null) {
			postDTOs = postDAO.getAllPosts();
		} else if (nickname != null && keyword == null) {
			postDTOs = postDAO.getPostsByNickname(nickname);
		} else if (nickname == null && keyword != null) {
			postDTOs = postDAO.getPostsByKeyword(keyword);
		}
		postDTOs.forEach(p -> {
			p.setPassword(null);
			p.setBody(null);
			p.setCreatedAt(null);
			p.setUpdatedAt(null);
		});
		return postDTOs;
	}

	@Override
	public PostDTO getPost(Long id) {
		PostDTO postDTO = postDAO.getPostById(id).orElseThrow();
		postDTO.setPassword(null);
		return postDTO;
	}

	@Override
	public PostDTO updatePost(Long id, PostDTO postDTO) throws Exception {
		// 접근 확인
		if (!id.equals(postDTO.getId())) {
			throw new Exception("잘못된 접근입니다.");
		}
		PostDTO postDtoToUpdate = postDAO.getPostById(id).orElseThrow();

		// 비밀번호 확인
		if (!passwordEncoder.matches(postDTO.getPassword(), postDtoToUpdate.getPassword())) {
			throw new Exception("비밀번호가 일치하지 않습니다.");
		} // 확인 작업 완료

		if (postDTO.getTitle() != null) {
			postDTO.setTitle(postDTO.getTitle().trim());
		}
		if (postDTO.getBody() != null) {
			postDTO.setBody(postDTO.getBody().trim());
		}
		PostDTO updated = postDAO.updatePost(postDTO);
		updated.setPassword(null);
		return updated;
	}

	@Override
	public void deletePost(Long id) {
		PostDTO postDTO = postDAO.getPostById(id).orElseThrow();
		postDAO.deletePost(id);
	}
}
