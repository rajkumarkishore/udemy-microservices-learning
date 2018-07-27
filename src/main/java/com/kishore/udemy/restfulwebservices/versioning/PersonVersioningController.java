package com.kishore.udemy.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PersonVersioningController {

	/**
	 * TECHNIQUE 1
	 */
	@GetMapping(path = "/v1/person")
	public PersonV1 getPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/v2/person")
	public PersonV2 getPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	/*
	 * END - TECHNIQUE 1
	 */

	/**
	 * TECHNIQUE 2
	 */
	@GetMapping(path = "/person/param", params = "version=1")
	public PersonV1 paramPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/param", params = "version=2")
	public PersonV2 paramPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	/*
	 * END - TECHNIQUE 2
	 */

	/**
	 * TECHNIQUE 3
	 */
	@GetMapping(path = "/person/header", headers = "X-API-VERSION=1")
	public PersonV1 headerPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/header", headers = "X-API-VERSION=2")
	public PersonV2 headerPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	/*
	 * END - TECHNIQUE 3
	 */
	
	/**
	 * TECHNIQUE 4
	 */
	@GetMapping(path = "/person/produces", produces = "application/my.company.com-v1+json")
	public PersonV1 producesPersonV1() {
		return new PersonV1("Bob Charlie");
	}

	@GetMapping(path = "/person/produces", produces = "application/my.company.com-v2+json")
	public PersonV2 producesPersonV2() {
		return new PersonV2(new Name("Bob", "Charlie"));
	}
	/*
	 * END - TECHNIQUE 4
	 */

}
