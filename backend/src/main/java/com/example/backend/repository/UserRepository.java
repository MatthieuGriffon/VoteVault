package com.example.backend.repository;

import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, UUID> {
    // Trouver un utilisateur par email
    Optional<User> findByEmail(String email);

    // Trouver un utilisateur par username
    Optional<User> findByUsername(String username);

    // Vérifier si un email existe
    boolean existsByEmail(String email);

    // Vérifier si un username existe
    boolean existsByUsername(String username);
}
