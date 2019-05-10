package com.yhw8930.springboot.controller;

import com.yhw8930.springboot.Entity.User;
import com.yhw8930.springboot.dao.UserRepository;
import com.yhw8930.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    UserService userService;
    @GetMapping("/user/{id}")
    public User getUserById(@PathVariable("id") Integer id) {
        return userRepository.findById(id).get();
    }

    @GetMapping("/user")
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @GetMapping("/user2")
    public User addUser2(User user){
        userService.addUser(user);
        return user;
    }

}
