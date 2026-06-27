package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@Builder
public class ParticipantRegistResponseDto {

    private Long participantId;
    private Long projectId;
    private Long userId;
    private String userName;
    private ProjectMemberRole participantRole;
    private ProjectMemberStatus participantStatus;
    private ProjectMemberGrade participantPermission;
    private LocalDateTime participantCreatedAt;
}
