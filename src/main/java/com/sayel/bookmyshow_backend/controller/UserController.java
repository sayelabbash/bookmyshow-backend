package com.sayel.bookmyshow_backend.controller;

import com.sayel.bookmyshow_backend.entity.User;
import com.sayel.bookmyshow_backend.repository.UserRepository;
import com.sayel.bookmyshow_backend.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public User createUser(@RequestBody User user){
        return  userService.saveUser(user);
    }
    @PostMapping("/login")
    public User login(@RequestParam String email,
                      @RequestParam String password) {
        return userService.login(email, password);
    }

}
