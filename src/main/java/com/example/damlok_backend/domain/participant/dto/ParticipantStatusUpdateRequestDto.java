package com.example.damlok_backend.domain.participant.dto;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantStatusUpdateRequestDto {

    @NotNull(message = "Participant id is required.")
    private Long participantId;

    @NotNull(message = "Participant status is required.")
    private ProjectMemberStatus participantStatus;
}
