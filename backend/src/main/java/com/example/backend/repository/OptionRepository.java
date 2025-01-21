package com.example.backend.repository;

import com.example.backend.model.Option;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface OptionRepository extends JpaRepository<Option, UUID> {
    // Trouver toutes les options d'un sondage
    List<Option> findByPollId(UUID pollId);
}
