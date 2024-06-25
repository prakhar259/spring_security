package com.prakhar.studentapp.service;

import com.prakhar.studentapp.entity.Roles;
import com.prakhar.studentapp.repository.RolesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RolesServiceImpl implements RolesService {

    @Autowired
    RolesRepository rolesRepository;

    @Override
    public void newRoles(Roles roles) {
        rolesRepository.save(roles);
    }
}
