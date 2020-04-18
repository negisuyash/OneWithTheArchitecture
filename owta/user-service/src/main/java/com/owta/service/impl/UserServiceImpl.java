package com.owta.service.impl;

import com.owta.model.User;
import com.owta.repository.UserRepository;
import com.owta.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public ResponseEntity<User> addUser(User user) {
        return ResponseEntity.status(HttpStatus.CREATED).body(userRepository.save(user));
    }

    @Override
    public ResponseEntity<User> updateUser(User user) {
        return ResponseEntity.status(201).body(userRepository.save(user));
    }

    @Override
    public ResponseEntity<String> deleteUser(int id) {
        userRepository.deleteById(id);
        return ResponseEntity.status(200).body("DELETED");
    }

    @Override
    public ResponseEntity<User> getUser(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.isPresent()?ResponseEntity.status(200).body(user.get()):ResponseEntity.status(HttpStatus.NOT_FOUND).body(user.get());
    }
}
