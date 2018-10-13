package com.naren;

public class InvalidDateFormatException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public InvalidDateFormatException() {
		super();
	}

	public InvalidDateFormatException(String message) {
		super(message);
	}

	public InvalidDateFormatException(String message, Throwable e) {
		super(message, e);
	}

}
