package com.tlcomunic.aut.dto;

import com.tlcomunic.aut.domain.User;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UsersOutput {
    
    private User[] users;
}
