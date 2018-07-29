package com.kishore.udemy.restfulwebservices.user;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostRepository extends JpaRepository<Post, Integer> {

	public Post findByIdAndUser(int postId, User user);
	

}
