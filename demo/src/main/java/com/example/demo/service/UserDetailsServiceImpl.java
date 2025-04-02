package com.example.demo.service;

import com.example.demo.model.UserTable;
import com.example.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service("UserDetailsService")
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String login) throws UsernameNotFoundException {
        UserTable user = userRepository.findByLogin(login).orElseThrow(()->new UsernameNotFoundException("User not found"));
        return new User(
                user.getLogin(),
                String.valueOf(user.getPasswd()),
                Collections.singletonList(new SimpleGrantedAuthority("USER"))
        );
    }
}
