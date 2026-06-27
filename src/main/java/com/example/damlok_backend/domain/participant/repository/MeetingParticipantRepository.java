package com.example.damlok_backend.domain.participant.repository;

import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface MeetingParticipantRepository extends JpaRepository<MeetingParticipant, Long> {
    @Query("""
            select mp
            from MeetingParticipant mp
            join fetch mp.meeting meeting
            join fetch mp.projectParticipant pp
            join fetch pp.user u
            where u.id = ?1
            order by meeting.meetingDate desc
            """)
    List<MeetingParticipant> findWithMeetingByProjectParticipantUserId(Long userId);

    List<MeetingParticipant> findByProjectParticipantUserId(Long userId);
}