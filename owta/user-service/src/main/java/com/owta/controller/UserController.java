package com.owta.controller;

import com.owta.model.User;
import com.owta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping(path = "/helloUser")
    public User helloUser(){
        User user=new User();
        user.setDob(LocalDate.now());
        user.setEmail("negisuyash1998@gmail.com");
        user.setName("Suyash");
        user.setRole("Admin");
        user.setPassword("1234");
        return userService.saveUser(user);
    }
}
