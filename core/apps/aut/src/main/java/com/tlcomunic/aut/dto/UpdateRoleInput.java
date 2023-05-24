package com.tlcomunic.aut.dto;

import com.tlcomunic.aut.enums.Role;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateRoleInput {
    
    private Role role;
}
