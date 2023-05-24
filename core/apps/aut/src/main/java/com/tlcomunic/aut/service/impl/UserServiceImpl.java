package com.tlcomunic.aut.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tlcomunic.aut.domain.User;
import com.tlcomunic.aut.repository.UserRepository;
import com.tlcomunic.aut.service.UserService;

import com.tlcomunic.aut.enums.Role;
import com.tlcomunic.aut.exception.IncorrectPasswordException;
import com.tlcomunic.aut.exception.NullValuesException;
import com.tlcomunic.aut.exception.UserAlreadyExistsException;
import com.tlcomunic.aut.exception.UserNotFoundException;

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
            throw new UserAlreadyExistsException();
            
        else {
            user.setCreatedAt(new Date());
            user.setUpdatedAt(new Date());
            return userRepository.save(user);
        }
    }
    
    @Override
    public User[] getUsers() {

        List<User> users = userRepository.findAll();

        return users.toArray(new User[users.size()]);
    }

    @Override
    public User getByEmail(String email) {
        
        if (email == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();
        else
            return _user.get();
    }
    
    @Override
    public User getByCredentials(String email, String password) {

        if (email == null || password == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();

        else if (!_user.get().getPassword().equals(password))
            throw new IncorrectPasswordException();
        
        else
            return _user.get();
    }

    @Transactional
    @Override
    public User updateEmail(String oldEmail, String newEmail) {
        
        if (oldEmail == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(oldEmail);

        if (!_user.isPresent())
            throw new UserNotFoundException();

        else {
            _user.get().setEmail(newEmail);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updatePassword(String email, String password) {

        if (email == null || password == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();
        
        else {
            _user.get().setPassword(password);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updateName(String email, String firstName, String lastName) {

        if (email == null || firstName == null || lastName == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();
    
        else {
            _user.get().setFirstName(firstName);
            _user.get().setLastName(lastName);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User updateRole(String email, Role role) {

        if (email == null || role == null )
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();
    
        else {
            _user.get().setRole(role);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User enable(String email) {
        
        if (email == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();

        else {
            _user.get().setEnable(true);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public User disable(String email) {
        
        if (email == null)
            throw new NullValuesException();

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();

        else {
            _user.get().setEnable(false);
            _user.get().setUpdatedAt(new Date());
            return userRepository.save(_user.get());
        }
    }

    @Transactional
    @Override
    public void deleteByEmail(String email) {

        Optional<User> _user = userRepository.findByEmail(email);

        if (!_user.isPresent())
            throw new UserNotFoundException();

        else
            LOG.info("User[{}] has been deleted", _user.get().getId());
            userRepository.deleteByEmail(email);
    }

}
