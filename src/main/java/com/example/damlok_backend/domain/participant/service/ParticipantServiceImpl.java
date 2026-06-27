package com.example.damlok_backend.domain.participant.service;

import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantDeleteResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantListResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantRegistResponseDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateRequestDto;
import com.example.damlok_backend.domain.participant.dto.ParticipantStatusUpdateResponseDto;
import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import com.example.damlok_backend.domain.participant.repository.ProjectParticipantRepository;
import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.domain.project.repository.ProjectRepository;
import com.example.damlok_backend.domain.user.entity.User;
import com.example.damlok_backend.domain.user.repository.UserRepository;
import jakarta.persistence.criteria.Predicate;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ParticipantServiceImpl implements ParticipantService {

    private final ProjectParticipantRepository participantRepository;
    private final ProjectRepository projectRepository;
    private final UserRepository userRepository;

    @Override
    @Transactional
    public ParticipantRegistResponseDto registParticipant(ParticipantRegistRequestDto request) {
        if (participantRepository.existsByProjectIdAndUserId(request.getProjectId(), request.getUserId())) {
            throw new IllegalArgumentException("Project participant already exists.");
        }

        Project project = projectRepository.findById(request.getProjectId())
                .orElseThrow(() -> new IllegalArgumentException("Project not found."));
        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() -> new IllegalArgumentException("User not found."));

        ProjectParticipant participant = ProjectParticipant.builder()
                .project(project)
                .user(user)
                .role(request.getParticipantRole())
                .status(request.getParticipantStatus())
                .grade(request.getParticipantPermission())
                .build();

        return toRegistResponse(participantRepository.save(participant));
    }

    @Override
    @Transactional(readOnly = true)
    public List<ParticipantListResponseDto> getParticipantList(ParticipantListRequestDto request) {
        return participantRepository.findAll(
                        buildParticipantSpecification(request),
                        Sort.by(Sort.Direction.ASC, "id")
                )
                .stream()
                .map(this::toListResponse)
                .toList();
    }

    @Override
    @Transactional
    public ParticipantDeleteResponseDto deleteParticipant(ParticipantDeleteRequestDto request) {
        ProjectParticipant participant = getParticipant(request.getParticipantId());
        Long participantId = participant.getId();

        participantRepository.delete(participant);

        return ParticipantDeleteResponseDto.builder()
                .participantId(participantId)
                .deleted(true)
                .message("Project participant has been hard deleted.")
                .build();
    }

    @Override
    @Transactional
    public ParticipantStatusUpdateResponseDto updateParticipantStatus(ParticipantStatusUpdateRequestDto request) {
        ProjectParticipant participant = getParticipant(request.getParticipantId());
        participant.updateStatus(request.getParticipantStatus());

        return toStatusUpdateResponse(participant);
    }

    private ProjectParticipant getParticipant(Long participantId) {
        if (participantId == null) {
            throw new IllegalArgumentException("Participant id is required.");
        }

        return participantRepository.findById(participantId)
                .orElseThrow(() -> new IllegalArgumentException("Project participant not found."));
    }

    private Specification<ProjectParticipant> buildParticipantSpecification(ParticipantListRequestDto request) {
        return (root, query, criteriaBuilder) -> {
            List<Predicate> predicates = new ArrayList<>();

            if (request.getProjectId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("project").get("id"), request.getProjectId()));
            }
            if (request.getUserId() != null) {
                predicates.add(criteriaBuilder.equal(root.get("user").get("id"), request.getUserId()));
            }
            if (StringUtils.hasText(request.getUserName())) {
                predicates.add(criteriaBuilder.like(
                        criteriaBuilder.lower(root.get("user").get("name")),
                        "%" + request.getUserName().trim().toLowerCase() + "%"
                ));
            }
            if (request.getParticipantRole() != null) {
                predicates.add(criteriaBuilder.equal(root.get("role"), request.getParticipantRole()));
            }
            if (request.getParticipantStatus() != null) {
                predicates.add(criteriaBuilder.equal(root.get("status"), request.getParticipantStatus()));
            }
            if (request.getParticipantPermission() != null) {
                predicates.add(criteriaBuilder.equal(root.get("grade"), request.getParticipantPermission()));
            }

            return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
        };
    }

    private ParticipantRegistResponseDto toRegistResponse(ProjectParticipant participant) {
        Project project = participant.getProject();
        User user = participant.getUser();

        return ParticipantRegistResponseDto.builder()
                .participantId(participant.getId())
                .projectId(project.getId())
                .userId(user.getId())
                .userName(user.getName())
                .participantRole(participant.getRole())
                .participantStatus(participant.getStatus())
                .participantPermission(participant.getGrade())
                .participantCreatedAt(participant.getCreatedAt())
                .build();
    }

    private ParticipantListResponseDto toListResponse(ProjectParticipant participant) {
        User user = participant.getUser();

        return ParticipantListResponseDto.builder()
                .userId(user.getId())
                .userName(user.getName())
                .participantRole(participant.getRole())
                .participantStatus(participant.getStatus())
                .participantPermission(participant.getGrade())
                .build();
    }

    private ParticipantStatusUpdateResponseDto toStatusUpdateResponse(ProjectParticipant participant) {
        User user = participant.getUser();

        return ParticipantStatusUpdateResponseDto.builder()
                .participantId(participant.getId())
                .userId(user.getId())
                .userName(user.getName())
                .participantStatus(participant.getStatus())
                .participantUpdatedAt(participant.getUpdatedAt())
                .build();
    }
}
