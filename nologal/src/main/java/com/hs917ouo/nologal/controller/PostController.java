package com.hs917ouo.nologal.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hs917ouo.nologal.dto.PostDTO;
import com.hs917ouo.nologal.service.PostService;

@RestController
@RequestMapping("/post")
public class PostController {

	private final PostService postService;

	public PostController(PostService postService) {
		this.postService = postService;
	}

	@GetMapping
	public ResponseEntity<?> getPosts(
		@RequestParam(required = false) String nickname,
		@RequestParam(required = false) String keyword
	) {
		try {
			return ResponseEntity.ok(postService.getPosts(nickname, keyword));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getPost(@PathVariable Long id) {
		try {
			return ResponseEntity.ok(postService.getPost(id));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}

	@PostMapping
	public ResponseEntity<?> addPost(@RequestBody PostDTO postDTO) {
		try {
			return ResponseEntity.ok(postService.addPost(postDTO));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}

	@PatchMapping("/{id}")
	public ResponseEntity<?> updatePost(@PathVariable Long id, @RequestBody PostDTO postDTO) {
		try {
			return ResponseEntity.ok(postService.updatePost(id, postDTO));
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<?> deletePost(@PathVariable Long id) {
		try {
			postService.deletePost(id);
			return ResponseEntity.ok().build();
		} catch (Exception e) {
			return ResponseEntity.status(500).body(e);
		}
	}
}
