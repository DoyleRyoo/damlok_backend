package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;
import java.util.Optional;

public interface ProjectParticipantRepository extends JpaRepository<ProjectParticipant, Long>, JpaSpecificationExecutor<ProjectParticipant> {
    List<ProjectParticipant> findByProjectId(Long projectId);

    Optional<ProjectParticipant> findByProjectIdAndUserId(Long projectId, Long userId);

    boolean existsByProjectIdAndUserId(Long projectId, Long userId);
}
