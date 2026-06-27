package com.example.damlok_backend.domain.participant.controller;

import com.example.damlok_backend.domain.participant.dto.ProjectParticipantCreateRequestDto;
import com.example.damlok_backend.domain.participant.dto.ProjectParticipantResponseDto;
import com.example.damlok_backend.domain.participant.dto.ProjectParticipantStatusRequestDto;
import com.example.damlok_backend.domain.participant.service.ProjectParticipantService;
import jakarta.validation.Valid;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/participant")
@RequiredArgsConstructor
public class ProjectParticipantController {

    private final ProjectParticipantService projectParticipantService;

    @PostMapping("/regist")
    public ResponseEntity<Long> createParticipant(
            @RequestBody  ProjectParticipantCreateRequestDto dto
    ) {
        return ResponseEntity.ok(projectParticipantService.createParticipant(dto));
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProjectParticipantResponseDto>> getParticipants(
            @RequestParam(required = false) Long pid
    ) {
        return ResponseEntity.ok(projectParticipantService.getParticipants(pid));
    }

    @DeleteMapping
    public ResponseEntity<Long> removeParticipant(
            @RequestParam Long projectMemberId
    ) {
        return ResponseEntity.ok(projectParticipantService.removeParticipant(projectMemberId));
    }

    @PatchMapping("/status")
    public ResponseEntity<Long> updateParticipantStatus(
            @RequestParam Long projectMemberId,
            @RequestBody  ProjectParticipantStatusRequestDto dto
    ) {
        return ResponseEntity.ok(projectParticipantService.updateParticipantStatus(projectMemberId, dto));
    }
}
