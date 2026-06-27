package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProjectParticipantCreateRequestDto {

    @NotNull
    private Long projectId;

    @NotNull
    private Long userId;

    private ProjectMemberRole role;
    private ProjectMemberGrade grade;
}
