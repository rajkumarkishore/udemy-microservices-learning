package com.kishore.udemy.restfulwebservices.post;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PostResource {

	@Autowired
	private PostDaoService service;

	// GET /user/{id}/posts
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrieveAllUserPosts(@PathVariable Integer id) {
		List<Post> posts = service.findAllPostsOfUser(id);
		if (posts == null) {
			throw new PostNotFoundException("id- " + id);
		}
		return posts;
	}

}
