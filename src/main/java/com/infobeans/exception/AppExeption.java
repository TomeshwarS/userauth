package com.infobeans.exception;

public class AppExeption extends RuntimeException {

	public AppExeption() {
	}

	private String message;

	public AppExeption(String message) {
		super(message);
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

}
