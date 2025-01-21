package com.example.backend.repository;

import com.example.backend.model.Poll;
import com.example.backend.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface PollRepository extends JpaRepository<Poll, UUID> {
    // Trouver tous les sondages créés par un utilisateur via l'objet User
    List<Poll> findByCreatedBy(User createdBy);

    // Alternative : Trouver tous les sondages créés par un utilisateur via son ID
    @Query("SELECT p FROM Poll p WHERE p.createdBy.id = :creatorId")
    List<Poll> findByCreatorId(@Param("creatorId") UUID creatorId);

    // Trouver les sondages actifs
    List<Poll> findByIsActive(boolean isActive);
}
