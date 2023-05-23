package com.tlcomunic.aut.dto;

import java.lang.reflect.Field;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RegisterInput {
    
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private boolean enable;
    private boolean accountNonExpired;
    private boolean accountNonLocked;
    private boolean credentialsNonExpired;
    private String role;

    public boolean anyFieldIsNull() {
        Field[] fields = this.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);

            try {
                Object value = field.get(this);
                if (value == null) {
                    return true;
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        return false;
    }
    
}
