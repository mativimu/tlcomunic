package com.tlcomunic.aut.util;


import org.springframework.stereotype.Component;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.dto.RegisterInput;
import com.tlcomunic.aut.enums.Role;
import com.tlcomunic.aut.exception.NullValuesException;

@Component
public class DTOFactory {
    
    public User getUser(RegisterInput inputDTO) {

        if (inputDTO.anyFieldIsNull())
            throw new NullValuesException();   
        else 
            return User.builder()
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
        
    }


}
