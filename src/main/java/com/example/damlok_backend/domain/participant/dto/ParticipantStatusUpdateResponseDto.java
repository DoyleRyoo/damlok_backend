package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ParticipantStatusUpdateResponseDto {

    private Long participantId;
    private Long userId;
    private String userName;
    private ProjectMemberStatus participantStatus;
    private LocalDateTime participantUpdatedAt;
}
