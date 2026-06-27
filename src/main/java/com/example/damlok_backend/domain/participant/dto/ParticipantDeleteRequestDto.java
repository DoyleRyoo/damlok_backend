package com.example.damlok_backend.domain.participant.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ParticipantDeleteRequestDto {

    @NotNull(message = "Participant id is required.")
    private Long participantId;
}
