package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {
}