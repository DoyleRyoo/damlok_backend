package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Getter
public class ProjectParticipantStatusRequestDto {

    @NotNull
    private ProjectMemberStatus status;
}
