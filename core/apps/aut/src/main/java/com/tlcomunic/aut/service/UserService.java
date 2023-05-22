package com.tlcomunic.aut.service;

import com.tlcomunic.aut.domain.User;

public interface UserService {

    public User create(User user);
    
    public User getByEmail(String email);

    public User updateBasicInfo(String firstName, String lastName, String email, String password, String role);
    
    public Boolean deleteByEmail(String email);

}
