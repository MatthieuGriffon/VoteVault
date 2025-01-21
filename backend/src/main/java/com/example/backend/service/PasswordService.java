package com.example.backend.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class PasswordService {
    private final PasswordEncoder passwordEncoder;

    // Constructeur pour initialiser BCryptPasswordEncoder
    public PasswordService() {
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // Méthode pour hasher un mot de passe
    public String hashPassword(String rawPassword) {
        return passwordEncoder.encode(rawPassword);
    }

    // Méthode pour vérifier un mot de passe
    public boolean matches(String rawPassword, String hashedPassword) {
        return passwordEncoder.matches(rawPassword, hashedPassword);
    }
}

