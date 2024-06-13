package com.prakhar.studentapp.controller;

import com.prakhar.studentapp.entity.Roles;
import com.prakhar.studentapp.entity.User;
import com.prakhar.studentapp.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

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

    @PostMapping("/newuser")
    public String newUser(@RequestBody User user){
        userService.createUser(user);
        return "User created !";
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
