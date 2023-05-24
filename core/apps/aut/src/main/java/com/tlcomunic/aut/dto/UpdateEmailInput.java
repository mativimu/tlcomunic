package com.tlcomunic.aut.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateEmailInput {
    
    private String email;

}