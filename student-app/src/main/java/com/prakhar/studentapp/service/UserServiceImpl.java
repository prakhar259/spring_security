package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.User;
import com.prakhar.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUserName(username);
    }

    @Override
    public void createUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedpwd);
        userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
       userRepository.deleteById(id);
    }

}
