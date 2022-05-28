package com.spring.jwt.model.service;

import com.spring.jwt.model.domain.User;
import com.spring.jwt.model.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepository repository;

    private PasswordEncoder encoder;

    public User createUser(User user){
        String pass = user.getPassword();
        user.setPassword(encoder.encode(pass));
       return repository.save(user);
    }
}
