package com.example.damlok_backend.domain.participant.service;

import com.example.damlok_backend.domain.participant.dto.ProjectParticipantCreateRequestDto;
import com.example.damlok_backend.domain.participant.dto.ProjectParticipantResponseDto;
import com.example.damlok_backend.domain.participant.dto.ProjectParticipantStatusRequestDto;
import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import com.example.damlok_backend.domain.participant.repository.ProjectParticipantRepository;
import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.domain.project.repository.ProjectRepository;
import com.example.damlok_backend.domain.user.entity.User;
import com.example.damlok_backend.domain.user.repository.UserRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class ProjectParticipantService {

    private final ProjectParticipantRepository projectParticipantRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    public Long createParticipant(ProjectParticipantCreateRequestDto dto) {
        Project project = projectRepository.findById(dto.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로젝트입니다."));

        User user = userRepository.findById(dto.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        ProjectParticipant participant = ProjectParticipant.builder()
                .project(project)
                .user(user)
                .role(dto.getRole() == null ? ProjectMemberRole.MEMBER : dto.getRole())
                .grade(dto.getGrade() == null ? ProjectMemberGrade.PARTICIPANT : dto.getGrade())
                .status(ProjectMemberStatus.ACTIVE)
                .build();

        return projectParticipantRepository.save(participant).getId();
    }

    @Transactional(readOnly = true)
    public List<ProjectParticipantResponseDto> getParticipants(Long projectId) {
        List<ProjectParticipant> participants = projectId == null
                ? projectParticipantRepository.findAll()
                : projectParticipantRepository.findByProjectId(projectId);

        return participants.stream()
                .map(this::toDto)
                .toList();
    }

    public Long removeParticipant(Long projectMemberId) {
        ProjectParticipant participant = getParticipant(projectMemberId);
        participant.setStatus(ProjectMemberStatus.REMOVED);
        return participant.getId();
    }

    public Long updateParticipantStatus(Long projectMemberId, ProjectParticipantStatusRequestDto dto) {
        if (dto.getStatus() == null) {
            throw new IllegalArgumentException("프로젝트 참가자 상태는 필수입니다.");
        }

        ProjectParticipant participant = getParticipant(projectMemberId);
        participant.setStatus(dto.getStatus());
        return participant.getId();
    }

    private ProjectParticipant getParticipant(Long projectMemberId) {
        return projectParticipantRepository.findById(projectMemberId)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 프로젝트 참가자입니다."));
    }

    private ProjectParticipantResponseDto toDto(ProjectParticipant participant) {
        return ProjectParticipantResponseDto.builder()
                .projectMemberId(participant.getId())
                .projectId(participant.getProject().getId())
                .userId(participant.getUser().getId())
                .userName(participant.getUser().getName())
                .userEmail(participant.getUser().getEmail())
                .role(participant.getRole())
                .grade(participant.getGrade())
                .status(participant.getStatus())
                .build();
    }
}
