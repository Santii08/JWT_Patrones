package com.example.jwtapi.service;

import com.example.jwtapi.config.RSAKeyProvider;
import com.example.jwtapi.model.User;
import io.jsonwebtoken.*;

import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class JwtService {

    private final RSAKeyProvider keyProvider;

    public JwtService(RSAKeyProvider keyProvider) {
        this.keyProvider = keyProvider;
    }

    // Firmar con la llave PÚBLICA (aunque no es lo usual)
    public String generateToken(User user) {
        return Jwts.builder()
                .setSubject(user.getUsername())
                .claim("role", user.getRole())
                .setExpiration(new Date(System.currentTimeMillis() + 120_000)) // 2 minutos
                .signWith(keyProvider.getPublicKey(), SignatureAlgorithm.RS256)
                .compact();
    }

    // Validar con la llave PRIVADA
    public Claims validateToken(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(keyProvider.getPrivateKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
