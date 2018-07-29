package com.kishore.udemy.restfulwebservices.user;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/jpa")
public class UserJpaResource {

	@Autowired
	private UserJpaRepository userRepository;

	@Autowired
	private PostRepository postRepository;

	// GET /users
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers() {
		return userRepository.findAll();
	}

	// GET /users/1
	@GetMapping(path = "/users/{id}")
	public User retrieveUserV1(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		return user.get();
	}

	@GetMapping(path = "/users/hateoas/{id}")
	public Resource<User> retrieveUser(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		Resource<User> resource = new Resource<>(user.get());

		// all-users SERVER_PATH + /users
		// retrieveAllusers
		ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllUsers());
		resource.add(linkTo.withRel("all-users"));

		// HATEOAS
		return resource;
	}

	// POST
	// input- user's detail
	// output- CREATED & return created user's URI
	@PostMapping(path = "/users")
	public ResponseEntity<Object> createUser(@Valid @RequestBody User user) {
		User createdUser = userRepository.save(user);

		// URI of created user /users/{createdUser.getId()}
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdUser.getId())
				.toUri();

		// return CREATED status with URI
		return ResponseEntity.created(uri).build();
	}

	// DELETE
	// input - user id
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		userRepository.deleteById(id);
	}

	// GET
	// input - user id
	// output - all posts of the user
	@GetMapping(path = "/users/{id}/posts")
	public List<Post> retrieveUserPosts(@PathVariable int id) {
		Optional<User> user = userRepository.findById(id);

		if (!user.isPresent()) {
			throw new UserNotFoundException("id-" + id);
		}

		return user.get().getPosts();
	}

	// POST
	// input - request body of user POST object
	@PostMapping(path = "/users/{id}/posts")
	public ResponseEntity<Post> createNewPost(@PathVariable int id, @RequestBody Post post) {

		Optional<User> userOptional = userRepository.findById(id);

		if (!userOptional.isPresent()) {
			throw new UserNotFoundException("id- " + id);
		}

		User user = userOptional.get();
		post.setUser(user);

		// save post
		Post createdPost = postRepository.save(post);

		// create post URI
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdPost.getId())
				.toUri();

		return ResponseEntity.created(uri).build();
	}

	// GET
	// input - user id , post id
	// output - user post
	@GetMapping(path = "/users/{userId}/posts/{postId}")
	public Post retreivePost(@PathVariable int userId, @PathVariable int postId) {
		Optional<User> optionalUser = userRepository.findById(userId);
		if (!optionalUser.isPresent()) {
			throw new UserNotFoundException("id- " + userId);
		}
		
		User user = optionalUser.get();

		Post post = postRepository.findByIdAndUser(postId, user);
		
		if(post == null) {
			throw new PostNotFoundException("id- " + postId);
		}

		return post;
	}

}
