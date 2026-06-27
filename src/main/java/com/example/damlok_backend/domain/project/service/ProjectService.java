package com.example.damlok_backend.domain.project.service;

import com.example.damlok_backend.domain.project.dto.CreateProjectRequestDto;
import com.example.damlok_backend.domain.project.dto.ProjectResponseDto;
import com.example.damlok_backend.domain.project.dto.UpdateProjectRequestDto;
import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.example.damlok_backend.domain.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    public ProjectResponseDto createProject(CreateProjectRequestDto request) {
        Project project = Project.builder()
                .title(normalizeRequired(request.getTitle(), "Project title is required."))
                .description(normalizeRequired(request.getContent(), "Project content is required."))
                .status(request.getStatus() == null ? ProjectStatus.ACTIVE : request.getStatus())
                .build();

        return toDto(projectRepository.save(project));
    }

    @Transactional(readOnly = true)
    public List<ProjectResponseDto> getProjectList() {
        return projectRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ProjectResponseDto getProjectDetail(Long pid) {
        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        return toDto(project);
    }

    @Transactional
    public ProjectResponseDto updateProject(Long pid, UpdateProjectRequestDto request) {
        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setTitle(normalizeRequired(request.getTitle(), "Project title is required."));
        project.setDescription(normalizeRequired(request.getContent(), "Project content is required."));

        if (request.getStatus() != null) {
            project.setStatus(request.getStatus());
        }

        return toDto(project);
    }

    @Transactional
    public ProjectResponseDto archiveProject(Long pid) {
        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setStatus(ProjectStatus.ARCHIVED);

        return toDto(project);
    }

    private ProjectResponseDto toDto(Project project) {
        return ProjectResponseDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .content(project.getDescription())
                .status(project.getStatus())
                .createdAt(project.getCreatedAt())
                .updatedAt(project.getUpdatedAt())
                .build();
    }

    private String normalizeRequired(String value, String message) {
        if (!StringUtils.hasText(value)) {
            throw new IllegalArgumentException(message);
        }

        return value.trim();
    }
}
