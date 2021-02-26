package com.example.demo.exception;

public class Exception {

	private Integer Id;
	private String message;
	
	public Exception() {
		super();
	}

	public Exception(Integer id, String message) {
		super();
		Id = id;
		this.message = message;
	}

	public Exception(String message) {
		super();
		this.message = message;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	
}
