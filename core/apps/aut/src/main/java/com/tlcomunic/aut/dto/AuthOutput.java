package com.tlcomunic.aut.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AuthOutput {
    
    private String token;
    private String scope;
}
