package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantListRequestDto {

    private Long projectId;
    private Long userId;
    private String userName;
    private ProjectMemberRole participantRole;
    private ProjectMemberStatus participantStatus;
    private ProjectMemberGrade participantPermission;
}
