package com.tlcomunic.aut.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateNameInput {
    
    private String firstName;
    private String lastName;
}
