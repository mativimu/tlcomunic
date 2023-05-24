package com.tlcomunic.aut.service;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.enums.Role;

public interface UserService {

    public User create(User user);

    public User getByEmail(String email);
    
    public User getByCredentials(String email, String password);

    public User updateEmail(String oldEmail, String newEmail);

    public User updatePassword(String email, String password);

    public User updateName(String email, String firstName, String lastName);

    public User updateRole(String email, Role role);

    public User enable(String email);

    public User disable(String email);
    
    public void deleteByEmail(String email);

}
