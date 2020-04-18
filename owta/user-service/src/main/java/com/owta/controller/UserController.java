package com.owta.controller;

import com.owta.model.User;
import com.owta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.ws.Response;
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

    @GetMapping(path = "/getUser/{id}")
    public ResponseEntity<User> getUser(@PathVariable("id") int id){
        return userService.getUser(id);
    }

    @PostMapping(path = "/addUser")
    public ResponseEntity<User> addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PutMapping(path = "/updateUser/{id}")
    public ResponseEntity<User> updateUser(@PathVariable("id")Integer id,@RequestBody User user){
        return userService.updateUser(id,user);
    }

    @DeleteMapping(path = "/removeUser/{id}")
    public ResponseEntity<String> removeUser(@PathVariable("id") int id){
        return userService.deleteUser(id);
    }
}
