package com.tlcomunic.aut.service.impl;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.repository.UserRepository;
import com.tlcomunic.aut.service.UserService;
import com.tlcomunic.aut.enums.Role;

@Service
public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    private static final Logger LOG = LoggerFactory.getLogger(UserServiceImpl.class);

    public UserServiceImpl(final UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    
    @Override
    public User create(User user) {
        
        Optional<User> _user = userRepository.findByEmail(user.getEmail());

        if (_user.isPresent())
            throw new RuntimeException("User already exists");
            
        else
            return userRepository.save(user);
    }
    
    @Override
    public User getByEmail(String email) {
        
        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");
        else
            return _user.get();

    }
    
    @Override
    public User getByCredentials(String email, String password) {

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else if (!_user.get().getPassword().equals(password))
            throw new RuntimeException("Incorrect password");
        
        else
            return _user.get();

    }

    @Override
    public User updateBasicInfo(String firstName, String lastName, String email, String password, String role) {

        if (firstName == null || lastName == null || email == null || password == null || role == null)
            throw new NullPointerException("There are null parameters");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent()){
            throw new RuntimeException("");
        } else {
            _user.get().setFirstName(firstName);
            _user.get().setLastName(lastName);
            _user.get().setEmail(email);
            _user.get().setPassword(password);
            _user.get().setRole(Role.valueOf(role));

            LOG.info("User[{}] has been updated", _user.get().getId());

            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else
            LOG.info("User[{}] has been deleted", _user.get().getId());
            userRepository.deleteByEmail(email);

    }

}
