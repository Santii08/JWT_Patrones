package com.example.jwtapi.config;

import java.security.*;
import java.util.Base64;

import org.springframework.stereotype.Component;

@Component
public class RSAKeyProvider {

    private PublicKey publicKey;
    private PrivateKey privateKey;

    public RSAKeyProvider() {
        try {
            KeyPairGenerator generator = KeyPairGenerator.getInstance("RSA");
            generator.initialize(2048);
            KeyPair keyPair = generator.generateKeyPair();
            this.publicKey = keyPair.getPublic();
            this.privateKey = keyPair.getPrivate();

            System.out.println("=== CLAVES RSA GENERADAS ===");
            System.out.println("Public Key: " + Base64.getEncoder().encodeToString(publicKey.getEncoded()));
            System.out.println("Private Key: " + Base64.getEncoder().encodeToString(privateKey.getEncoded()));
        } catch (Exception e) {
            throw new RuntimeException("Error generando llaves RSA", e);
        }
    }

    public PublicKey getPublicKey() {
        return publicKey;
    }

    public PrivateKey getPrivateKey() {
        return privateKey;
    }
}
