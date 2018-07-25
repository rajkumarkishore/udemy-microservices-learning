package com.kishore.udemy.restfulwebservices.exception;

import java.util.Date;

public class ExceptionResponse {

	private Date timeStamp;
	private String message;
	private String description;

	public ExceptionResponse(Date timeStamp, String message, String description) {
		super();
		this.timeStamp = timeStamp;
		this.message = message;
		this.description = description;
	}

	public Date getTimeStamp() {
		return timeStamp;
	}

	public String getMessage() {
		return message;
	}

	public String getDescription() {
		return description;
	}

}
