package com.example.backend.service;

import com.example.backend.model.User;
import com.example.backend.repository.UserRepository;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final PasswordService passwordService;

    @Autowired
    public UserService(UserRepository userRepository, PasswordService passwordService) {
        this.userRepository = userRepository;
        this.passwordService = passwordService;
    }

    // Inscription utilisateur
    public User registerUser(String username, String email, String rawPassword) {
        User user = new User();
        user.setUsername(username);
        user.setEmail(email);

        // Hasher le mot de passe avant de l'enregistrer
        String hashedPassword = passwordService.hashPassword(rawPassword);
        user.setPassword(hashedPassword);

        // Sauvegarder l'utilisateur dans la base de données
        return userRepository.save(user);
    }

    public boolean login(String email, String rawPassword) {
        Optional<User> optionalUser = userRepository.findByEmail(email);
    
        // Vérifier si un utilisateur existe pour cet email
        if (optionalUser.isEmpty()) {
            return false;
        }
    
        // Récupérer l'utilisateur
        User user = optionalUser.get();
    
        // Vérifier si le mot de passe correspond
        return passwordService.matches(rawPassword, user.getPassword());
    }

    public Optional<User> getUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    public Object getAllUsers() {
        return userRepository.findAll();
    }
}
