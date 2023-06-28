package com.tlcomunic.aut.exception;

public class InvalidPasswordException extends RuntimeException {

	private static final long serialVersionUID = 1l;

	public static final String ERR_MESSAGE = "Invalid Password";

	public InvalidPasswordException() {
		super(ERR_MESSAGE);
	}
}