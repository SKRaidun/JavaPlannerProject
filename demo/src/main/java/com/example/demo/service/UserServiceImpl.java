package com.example.demo.service;

import com.example.demo.model.UserTable;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserTable saveNewUser(UserTable user) {
        user.setPasswd(passwordEncoder.encode(String.valueOf(user.getPasswd())).toCharArray());
       return userRepository.save(user);
    }

    @Override
    public Iterable<UserTable> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public UserTable getCurrentUser() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        org.springframework.security.core.userdetails.User principal =

                (org.springframework.security.core.userdetails.User) authentication.getPrincipal();

        return userRepository.findByLogin(principal.getUsername())

                .orElseThrow(() -> new IllegalArgumentException("user not found"));
    }


}
