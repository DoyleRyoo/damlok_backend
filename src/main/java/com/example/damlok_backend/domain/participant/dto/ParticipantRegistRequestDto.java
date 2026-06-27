package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantRegistRequestDto {

    @NotNull(message = "Project id is required.")
    private Long projectId;

    @NotNull(message = "User id is required.")
    private Long userId;

    @NotNull(message = "Participant role is required.")
    private ProjectMemberRole participantRole;

    @NotNull(message = "Participant status is required.")
    private ProjectMemberStatus participantStatus;

    @NotNull(message = "Participant permission is required.")
    private ProjectMemberGrade participantPermission;
}
