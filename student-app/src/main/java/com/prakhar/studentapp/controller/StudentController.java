package com.prakhar.studentapp.controller;

import com.prakhar.studentapp.entity.Roles;
import com.prakhar.studentapp.entity.User;
import com.prakhar.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private UserService userService;

    @GetMapping(value = {"/", "/login"})
    public ModelAndView login() {
        return new ModelAndView("login");
    }

    @GetMapping("/home")
    public ModelAndView home() {
        return new ModelAndView("home");
    }

    @GetMapping("/manage-student")
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public ModelAndView manageStudent() {
        return new ModelAndView("manage-student");
    }
    @GetMapping("/access-denied")
    public ModelAndView accessDenied() {
        return new ModelAndView("access-denied");
    }

    @GetMapping("/user")
    @PreAuthorize("hasAuthority('PROFESSOR')")
    public List<User> getAllUser(){
        return userService.getAllUser();
    }

    @PostMapping("/newuser")
    public User newUser(@RequestBody User user){
//        if(user.getRoles() != null) {
//            for(Roles role : user.getRoles()) {
//                role.setUser(user);
//            }
//        }
//        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
//        user.setPassword(encoder.encode(user.getPassword()));
        return userService.createUser(user);

    }

//    @PostMapping("/newroles")
//    public String newRole(@RequestBody Roles roles){
//
//    }

    @GetMapping("/user/{username}")
    public ResponseEntity<User> getUser(@PathVariable String username){
        User user = userService.getUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @DeleteMapping("/user/{id}")
    public String removeUser(@PathVariable Long id){
        userService.removeUser(id);
        return "User Deleted Successfully";

    }


}
