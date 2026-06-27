package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long> {
    List<ProjectParticipant> findByProjectId(Long projectId);
}