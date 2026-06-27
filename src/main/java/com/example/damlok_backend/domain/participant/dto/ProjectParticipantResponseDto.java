package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectParticipantResponseDto {

    private Long projectMemberId;
    private Long projectId;
    private Long userId;
    private String userName;
    private String userEmail;
    private ProjectMemberRole role;
    private ProjectMemberGrade grade;
    private ProjectMemberStatus status;
}
