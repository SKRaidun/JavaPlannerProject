package com.example.demo.service;

import com.example.demo.model.UserTable;

public interface UserService {
    UserTable saveNewUser(UserTable user);
    Iterable<UserTable> findAllUsers();
    UserTable getCurrentUser();
}
