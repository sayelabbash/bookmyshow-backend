package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.User;
import com.sayel.bookmyshow_backend.repository.UserRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserRepository userRepository;

    public UserController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    @PostMapping
    public User createUser(@RequestBody User user){
        return  userRepository.save(user);
    }
}
