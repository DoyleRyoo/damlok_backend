package com.example.damlok_backend.domain.participant.entity;

import com.example.damlok_backend.domain.meeting.entity.Meeting;
import com.example.damlok_backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class MeetingParticipant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id")
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_participant_id")
    private ProjectParticipant projectParticipant;
}