package com.kishore.udemy.restfulwebservices.post;

import java.util.Date;

public class Post {

	private Integer id;
	private String content;
	private Date date;

	public Post() {
		super();
	}

	public Post(Integer id, String content, Date date) {
		super();
		this.id = id;
		this.content = content;
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
