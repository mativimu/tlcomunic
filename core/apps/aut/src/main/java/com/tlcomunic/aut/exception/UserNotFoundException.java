package com.tlcomunic.aut.exception;

public class UserNotFoundException extends RuntimeException {
    
    private static final long serialVersionUID = 1l;

    public static final String ERR_MESSAGE = "User not found";

    public UserNotFoundException() {
        super(ERR_MESSAGE);
    }
}