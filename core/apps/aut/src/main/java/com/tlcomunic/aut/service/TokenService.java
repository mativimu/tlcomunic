package com.tlcomunic.aut.service;

import com.tlcomunic.aut.domain.User;

public interface TokenService {
    
    public String generate(User user);

    public Boolean verify(String token);

}
