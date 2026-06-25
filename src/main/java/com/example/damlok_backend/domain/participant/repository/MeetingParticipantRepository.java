package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingParticipantRepository extends JpaRepository<MeetingParticipant, Long> {
    List<MeetingParticipant> findByProjectParticipantUserId(Long userId);
}