package com.tlcomunic.aut.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tlcomunic.aut.enums.Role;
import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.dto.AuthInput;
import com.tlcomunic.aut.dto.AuthOutput;
import com.tlcomunic.aut.dto.RegisterInput;
import com.tlcomunic.aut.dto.RegisterOutput;
import com.tlcomunic.aut.service.UserService;
import com.tlcomunic.aut.service.impl.JsonWebTokenService;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;
    
    private JsonWebTokenService jsonWebTokenService;
    
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserController(final UserService userService ,final JsonWebTokenService jsonWebTokenService) {
        this.userService = userService;
        this.jsonWebTokenService = jsonWebTokenService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthInput inputDTO) {

        User user = userService.getByEmail(inputDTO.getEmail());
        
        LOG.debug("Token requested for user id[{}]",String.valueOf(user.getId()));

        if (user.getPassword().equals(inputDTO.getPassword())) {

            String token = jsonWebTokenService.generate(user);
            String code = "#".concat(user.getRole().name().substring(0, 2));
            AuthOutput outputDTO = AuthOutput.builder().code(code).token(token).build();

            return ResponseEntity.status(HttpStatus.OK).body(outputDTO);

        } else
            throw new RuntimeException("Incorrect password");
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterInput inputDTO) {

        // DTOFactory implementation (filter nulls)
        User user = User.builder()
            .firstName(inputDTO.getFirstName())
            .lastName(inputDTO.getLastName())
            .email(inputDTO.getEmail())
            .password(inputDTO.getPassword())
            .enable(inputDTO.isEnable())
            .accountNonExpired(inputDTO.isAccountNonExpired())
            .accountNonLocked(inputDTO.isAccountNonLocked())
            .credentialsNonExpired(inputDTO.isCredentialsNonExpired())
            .role(Role.valueOf(inputDTO.getRole()))
            .build();

        User _user = userService.create(user);

        String token = jsonWebTokenService.generate(_user);
        String code = "#".concat(_user.getRole().name().substring(0, 2));
        RegisterOutput outputDTO = RegisterOutput.builder().code(code).token(token).build();

        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
        
    }

    @PutMapping("/update-info")
    public ResponseEntity<?> update() {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete() {
        return ResponseEntity.status(HttpStatus.OK).body("Delete:: delete");
    }
}
