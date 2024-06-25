package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.User;

import java.util.List;

public interface UserService {

    User getUserByUsername(String username);
    List<User> getAllUser();

    User createUser(User user);

    void removeUser(Long id);


}
