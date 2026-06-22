package com.example.damlok_backend.domain.meeting.repository;

import com.example.damlok_backend.domain.meeting.entity.Meeting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetingRepository extends JpaRepository<Meeting, Long> {
}