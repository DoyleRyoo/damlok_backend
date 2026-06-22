package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingParticipantRepository extends JpaRepository<MeetingParticipant, Long> {
}