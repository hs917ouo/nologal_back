package com.hs917ouo.nologal.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.hs917ouo.nologal.entity.Post;

public interface PostRepository extends JpaRepository<Post, Long> {

	List<Post> findByNickname(String nickname);

	@Query("""
		SELECT p
		  FROM Post p
		 WHERE p.title LIKE %:keyword%
		    OR p.body LIKE %:keyword%
		""")
	List<Post> findByKeyword(@Param("keyword") String keyword);
}
