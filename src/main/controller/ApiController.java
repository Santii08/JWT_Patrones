package com.example.jwtapi.controller;

import io.jsonwebtoken.Claims;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ApiController {

    @GetMapping("/saludo")
    public String saludo(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        if (claims == null) return "No autorizado";

        String role = (String) claims.get("role");
        if (role.equals("basic") || role.equals("admin")) {
            return "Hola " + claims.getSubject();
        }
        return "Acceso denegado";
    }

    @GetMapping("/despido")
    public String despido(HttpServletRequest request) {
        Claims claims = (Claims) request.getAttribute("claims");
        if (claims == null) return "No autorizado";

        String role = (String) claims.get("role");
        if (role.equals("admin")) {
            return "Adiós " + claims.getSubject();
        }
        return "Acceso denegado";
    }
}
