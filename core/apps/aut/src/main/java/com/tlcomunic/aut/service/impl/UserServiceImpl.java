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
        
        if (email == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");
        else
            return _user.get();
    }
    
    @Override
    public User getByCredentials(String email, String password) {

        if (email == null || password == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else if (!_user.get().getPassword().equals(password))
            throw new RuntimeException("Incorrect password");
        
        else
            return _user.get();
    }

    @Transactional
    @Override
    public User updateEmail(String oldEmail, String newEmail) {
        
        if (oldEmail == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(oldEmail);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else {
            _user.get().setEmail(newEmail);
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updatePassword(String email, String password) {

        if (email == null || password == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");
        
        else {
            _user.get().setPassword(password);
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updateName(String email, String firstName, String lastName) {

        if (email == null || firstName == null || lastName == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");
    
        else {
            _user.get().setFirstName(firstName);
            _user.get().setLastName(lastName);
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updateRole(String email, Role role) {

        if (email == null || role == null )
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");
    
        else {
            _user.get().setRole(role);
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User enable(String email) {
        
        if (email == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else {
            _user.get().setEnable(true);
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User disable(String email) {
        
        if (email == null)
            throw new RuntimeException("There are null values");

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new RuntimeException("User not found");

        else {
            _user.get().setEnable(false);
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
