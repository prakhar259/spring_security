package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.Roles;
import com.prakhar.studentapp.entity.User;
import com.prakhar.studentapp.repository.RolesRepository;
import com.prakhar.studentapp.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RolesRepository roleRepository;

    public User getUserByUsername(String username){
        return userRepository.findByUserName(username);
    }

    @Override
    public List<User> getAllUser() {
//        return userRepository.getAllUser();
       return userRepository.findAll();
    }

    @Override
    public User createUser(User user) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        String encodedpwd = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedpwd);
        if(user.getRoles() != null) {
            user.getRoles().forEach(roles -> {
                Roles roleEntity = roleRepository.findByRole(roles.getRole());
                    if(roleEntity == null) {
                    roleEntity = roleRepository.save(roles);
                }
                roles.setId(roleEntity.getId());
            });
        }
        return userRepository.save(user);
    }

    @Override
    public void removeUser(Long id) {
       userRepository.deleteById(id);
    }

}
