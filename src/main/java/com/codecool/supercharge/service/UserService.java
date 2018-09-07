package com.codecool.supercharge.service;

import com.codecool.supercharge.model.User;
import com.codecool.supercharge.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public void saveUser(User user){
        userRepository.save(user);
    }
}
