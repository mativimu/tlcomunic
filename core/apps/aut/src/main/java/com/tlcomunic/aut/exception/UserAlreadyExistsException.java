package com.tlcomunic.aut.exception;

public class UserAlreadyExistsException extends RuntimeException {
    
    private static final long serialVersionUID = 1l;

    public static final String ERR_MESSAGE = "User already exists";

    public UserAlreadyExistsException() {
        super(ERR_MESSAGE);
    }
}