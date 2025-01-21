package com.example.backend.repository;

import com.example.backend.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface VoteRepository extends JpaRepository<Vote, UUID> {
    // Trouver tous les votes d'un utilisateur pour un sondage donné
    List<Vote> findByPollIdAndUserId(UUID pollId, UUID userId);

    // Trouver tous les votes pour une option spécifique
    List<Vote> findByOptionId(UUID optionId);
}
