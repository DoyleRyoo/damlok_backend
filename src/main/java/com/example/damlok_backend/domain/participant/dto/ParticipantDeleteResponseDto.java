package com.example.damlok_backend.domain.participant.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ParticipantDeleteResponseDto {

    private Long participantId;
    private boolean deleted;
    private String message;
}
