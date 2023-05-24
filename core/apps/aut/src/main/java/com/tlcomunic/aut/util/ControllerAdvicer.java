package com.tlcomunic.aut.util;

import java.sql.SQLException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.tlcomunic.aut.dto.ErrorDTO;
import com.tlcomunic.aut.exception.UserNotFoundException;
import com.tlcomunic.aut.exception.IncorrectPasswordException;
import com.tlcomunic.aut.exception.UserAlreadyExistsException;
import com.tlcomunic.aut.exception.NullValuesException;

@RestControllerAdvice
public class ControllerAdvicer {
    
    @ExceptionHandler(value = UserNotFoundException.class)
    public ResponseEntity<ErrorDTO> userNotFoundException() {
        ErrorDTO err = ErrorDTO.builder()
            .code("ERR01")
            .message("User not found")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(value = IncorrectPasswordException.class)
    public ResponseEntity<ErrorDTO> incorrectPasswordException() {
        ErrorDTO err = ErrorDTO.builder()
            .code("ERR02")
            .message("Incorrect Password")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(value = UserAlreadyExistsException.class)
    public ResponseEntity<ErrorDTO> userAlreadyExistsException() {
        ErrorDTO err = ErrorDTO.builder()
            .code("ERR03")
            .message("User already exists")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }

    @ExceptionHandler(value = NullValuesException.class)
    public ResponseEntity<ErrorDTO> nullValuesException() {
        ErrorDTO err = ErrorDTO.builder()
            .code("ERR04")
            .message("There are null values")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
    
    @ExceptionHandler(value =  { SQLException.class })
    public ResponseEntity<ErrorDTO> sqlException() {
        ErrorDTO err = ErrorDTO.builder()
            .code("ERR05")
            .message("SQL error")
            .build();
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(err);
    }
}
