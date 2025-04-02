package com.example.demo.controller;

import com.example.demo.model.UserTable;
import com.example.demo.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @Autowired
    private UserServiceImpl userService;

    @PostMapping("/users")
    public UserTable create(@RequestBody UserTable user) {
        System.out.println(user.getLogin());
        System.out.println(user.getPasswd());
        return userService.saveNewUser(user);
    }

    @GetMapping("/users")
    public Iterable<UserTable> getUser() {
        return userService.findAllUsers();
    }

}
