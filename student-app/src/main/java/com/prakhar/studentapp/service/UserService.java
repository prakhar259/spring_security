package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.User;
import com.prakhar.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUserName(username);
    }

}
