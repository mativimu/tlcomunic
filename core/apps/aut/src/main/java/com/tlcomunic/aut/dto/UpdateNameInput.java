package com.tlcomunic.aut.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UpdateNameInput {
    
    private String fisrtName;
    private String lastName;
}
