package com.kishore.udemy.restfulwebservices.post;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Component;

@Component
public class PostDaoService {

	private static Map<Integer, List<Post>> userPosts = new HashMap<>();

	static {
		List<Post> user1posts = new ArrayList<>();
		user1posts.add(new Post(1, "post1", new Date()));
		user1posts.add(new Post(2, "post2", new Date()));
		user1posts.add(new Post(3, "post3", new Date()));
		userPosts.put(1, user1posts);

		List<Post> user2posts = new ArrayList<>();
		user2posts.add(new Post(4, "post4", new Date()));
		user2posts.add(new Post(5, "post5", new Date()));
		user2posts.add(new Post(6, "post6", new Date()));
		userPosts.put(2, user2posts);
	}

	public List<Post> findAllPostsOfUser(int id) {
		return userPosts.get(id);
	}

}
