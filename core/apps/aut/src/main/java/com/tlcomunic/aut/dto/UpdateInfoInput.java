package com.tlcomunic.aut.dto;

import javax.management.relation.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateInfoInput {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enable;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private Role role;
    
}
