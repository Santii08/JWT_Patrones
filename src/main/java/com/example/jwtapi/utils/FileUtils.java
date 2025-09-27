package com.example.jwtapi.utils;

import com.example.jwtapi.model.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {

    // Cargar usuarios desde un archivo TXT (username,password,role)
    public static List<User> loadUsers(String filename) {
        List<User> users = new ArrayList<>();

        try {
            InputStream inputStream = FileUtils.class.getClassLoader().getResourceAsStream(filename);
            if (inputStream == null) {
                throw new RuntimeException("No se encontró el archivo: " + filename);
            }

            try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
                String line;
                while ((line = reader.readLine()) != null) {
                    String[] parts = line.split(",");
                    if (parts.length == 3) {
                        users.add(new User(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo de usuarios", e);
        }

        return users;
    }
}