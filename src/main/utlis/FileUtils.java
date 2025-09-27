package com.example.jwtapi.util;

import com.example.jwtapi.model.User;

import java.io.*;
import java.nio.file.*;
import java.util.*;

public class FileUtils {
    public static List<User> loadUsers(String filename) {
        List<User> users = new ArrayList<>();
        try {
            List<String> lines = Files.readAllLines(Paths.get("src/main/resources/" + filename));
            for (String line : lines) {
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    users.add(new User(parts[0], parts[1], parts[2]));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("Error leyendo usuarios", e);
        }
        return users;
    }
}
