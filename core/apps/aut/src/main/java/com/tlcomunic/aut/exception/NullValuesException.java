package com.tlcomunic.aut.exception;

public class NullValuesException extends RuntimeException {

	private static final long serialVersionUID = 1l;

	public static final String ERR_MESSAGE = "There are null values";

	public NullValuesException() {
		super(ERR_MESSAGE);
	}
}