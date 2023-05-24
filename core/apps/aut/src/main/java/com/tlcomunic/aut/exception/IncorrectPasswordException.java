package com.tlcomunic.aut.exception;

public class IncorrectPasswordException extends RuntimeException {
    
    private static final long serialVersionUID = 1l;

    public static final String ERR_MESSAGE = "Incorrect Password";

    public IncorrectPasswordException() {
        super(ERR_MESSAGE);
    }
}