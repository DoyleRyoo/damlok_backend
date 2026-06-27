package com.example.damlok_backend.domain.participant.controller;

import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateResponseDto;
import com.example.damlok_backend.domain.participant.service.ParticipantService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/participant")
@RequiredArgsConstructor
public class ParticipantController {

    private final ParticipantService participantService;

    @PostMapping("/regist")
    public ParticipantRegistResponseDto registParticipant(
            @Valid @RequestBody ParticipantRegistRequestDto request
    ) {
        return participantService.registParticipant(request);
    }

    @GetMapping("/list")
    public List<ParticipantListResponseDto> getParticipantList(
            @ModelAttribute ParticipantListRequestDto request
    ) {
        return participantService.getParticipantList(request);
    }

    @DeleteMapping
    public ParticipantDeleteResponseDto deleteParticipant(
            @Valid @RequestBody ParticipantDeleteRequestDto request
    ) {
        return participantService.deleteParticipant(request);
    }

    @PatchMapping("/status")
    public ParticipantStatusUpdateResponseDto updateParticipantStatus(
            @Valid @RequestBody ParticipantStatusUpdateRequestDto request
    ) {
        return participantService.updateParticipantStatus(request);
    }
}
