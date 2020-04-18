package com.owta.service;

import com.owta.model.User;
import org.springframework.http.ResponseEntity;

public interface UserService {

    User saveUser(User user);

    ResponseEntity<User> addUser(User user);

    ResponseEntity<User> updateUser(User user);

    ResponseEntity<String> deleteUser(int id);

    ResponseEntity<User> getUser(int id);
}
