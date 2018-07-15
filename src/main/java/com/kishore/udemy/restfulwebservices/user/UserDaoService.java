package com.kishore.udemy.restfulwebservices.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class UserDaoService {

	private static List<User> users = new ArrayList<>();

	private int userCount = 3;
	static {
		users.add(new User(1, "Tom", new Date()));
		users.add(new User(2, "Dick", new Date()));
		users.add(new User(3, "Harry", new Date()));
	}

	// find all
	public List<User> findAll() {
		return users;
	}

	// save
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		users.add(user);
		return user;
	}

	// find one
	public User findOne(int id) {
		User user = users.stream().filter(u -> u.getId() == id).findAny().orElse(null);
		return user;
	}

}
