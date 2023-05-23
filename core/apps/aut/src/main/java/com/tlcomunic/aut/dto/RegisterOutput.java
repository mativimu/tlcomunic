package com.tlcomunic.aut.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterOutput {
        
    private String code;
    private String token;
    
}
