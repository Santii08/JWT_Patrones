package com.example.jwtapi.controller;

import com.example.jwtapi.model.User;
import com.example.jwtapi.service.JwtService;
import com.example.jwtapi.service.UserService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final UserService userService;
    private final JwtService jwtService;

    public AuthController(UserService userService, JwtService jwtService) {
        this.userService = userService;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password) {
        User user = userService.validateUser(username, password);
        if (user == null) {
            return "Usuario o clave inválidos";
        }
        return jwtService.generateToken(user);
    }
}
