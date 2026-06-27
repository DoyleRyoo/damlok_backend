package com.example.damlok_backend.domain.participant.service;

import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateResponseDto;

import java.util.List;

public interface ParticipantService {

    ParticipantRegistResponseDto registParticipant(ParticipantRegistRequestDto request);

    List<ParticipantListResponseDto> getParticipantList(ParticipantListRequestDto request);

    ParticipantDeleteResponseDto deleteParticipant(ParticipantDeleteRequestDto request);

    ParticipantStatusUpdateResponseDto updateParticipantStatus(ParticipantStatusUpdateRequestDto request);
}
