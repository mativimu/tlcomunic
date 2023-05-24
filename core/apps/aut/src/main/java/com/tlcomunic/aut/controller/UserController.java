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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.dto.AuthInput;
import com.tlcomunic.aut.dto.AuthOutput;
import com.tlcomunic.aut.dto.DeleteUserInput;
import com.tlcomunic.aut.dto.MessageOutput;
import com.tlcomunic.aut.dto.RegisterInput;
import com.tlcomunic.aut.dto.RegisterOutput;
import com.tlcomunic.aut.dto.UpdateNameInput;
import com.tlcomunic.aut.dto.UpdatePassInput;
import com.tlcomunic.aut.service.UserService;
import com.tlcomunic.aut.service.impl.JsonWebTokenService;
import com.tlcomunic.aut.util.DTOFactory;

@RestController
@RequestMapping("/user")
public class UserController {

    private UserService userService;

    private DTOFactory dtoFactory;
    
    private JsonWebTokenService jsonWebTokenService;
    
    private static final Logger LOG = LoggerFactory.getLogger(UserController.class);

    public UserController(final UserService userService, final DTOFactory dtoFactory, final JsonWebTokenService jsonWebTokenService) {
        this.userService = userService;
        this.dtoFactory = dtoFactory;
        this.jsonWebTokenService = jsonWebTokenService;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestBody AuthInput inputDTO) {
        
        User user = userService.getByCredentials(inputDTO.getEmail(), inputDTO.getPassword());

        LOG.info("User[{}] authenticated",String.valueOf(user.getId()));
        
        String token = jsonWebTokenService.generate(user);
        String scope = "#00".concat(user.getRole().name().substring(0, 2));
        AuthOutput outputDTO = AuthOutput.builder().scope(scope).token(token).build();

        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterInput inputDTO) {

        User user = userService.create(dtoFactory.getUser(inputDTO));

        LOG.info("User[{}] created as {}", String.valueOf(user.getId()), user.getRole());

        String token = jsonWebTokenService.generate(user);
        String code = "#".concat(user.getRole().name().substring(0, 2));
        RegisterOutput outputDTO = RegisterOutput.builder().code(code).token(token).build();

        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
        
    }

    @PutMapping("/update/email")
    public ResponseEntity<?> updateEmail(@RequestParam(name="email") String email) {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @PutMapping("/update/password")
    public ResponseEntity<?> updatePassowrd(@RequestParam(name="email") String email, @RequestBody UpdatePassInput inputDTO ) {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @PutMapping("/update/name")
    public ResponseEntity<?> updateName(@RequestParam(name="email") String email, UpdateNameInput inputDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @PutMapping("/update/disable")
    public ResponseEntity<?> updateName(@RequestParam(name="email") String email, UpdateNameInput inputDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @PutMapping("/update/role")
    public ResponseEntity<?> updateName(@RequestParam(name="email") String email, UpdateNameInput inputDTO) {
        return ResponseEntity.status(HttpStatus.OK).body("Put:: update");
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestBody DeleteUserInput inputDTO) {

        User user = userService.getByCredentials(inputDTO.getEmail(), inputDTO.getPassword());

        userService.deleteByEmail(user.getEmail());

        MessageOutput outputDTO = MessageOutput.builder()
            .message("User deleted successfully")
            .build();

        return ResponseEntity.status(HttpStatus.OK).body(outputDTO);
    }
}
