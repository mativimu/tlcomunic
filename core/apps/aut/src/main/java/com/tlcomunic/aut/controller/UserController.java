package com.tlcomunic.aut.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    
    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate() {
        return ResponseEntity.status(HttpStatus.OK).body("Get:: authenticate");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register() {
        return ResponseEntity.status(HttpStatus.OK).body("Post:: register");
    }

    @PutMapping("/update")
    public ResponseEntity<?> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        return ResponseEntity.status(HttpStatus.OK).body("Delete:: delete");
    }
}
