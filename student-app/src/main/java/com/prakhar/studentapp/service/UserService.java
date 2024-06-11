package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.User;

public interface UserService {

    User getUserByUsername(String username);

    void createUser(User user);

    void removeUser(Long id);


}
