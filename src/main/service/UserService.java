package com.example.jwtapi.service;

import com.example.jwtapi.model.User;
import com.example.jwtapi.util.FileUtils;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final List<User> users;

    public UserService() {
        this.users = FileUtils.loadUsers("users.txt");
    }

    public User validateUser(String username, String password) {
        return users.stream()
                .filter(u -> u.getUsername().equals(username) && u.getPassword().equals(password))
                .findFirst()
                .orElse(null);
    }
}
