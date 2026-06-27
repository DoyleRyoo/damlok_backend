package com.example.damlok_backend.domain.project.service;

import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.domain.company.repository.CompanyRepository;
import com.example.damlok_backend.domain.project.dto.CreateProjectRequestDto;
import com.example.damlok_backend.domain.project.dto.ProjectResponseDto;
import com.example.damlok_backend.domain.project.dto.UpdateProjectRequestDto;
import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.example.damlok_backend.domain.project.repository.ProjectRepository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProjectService {

    private final ProjectRepository projectRepository;
    private final CompanyRepository companyRepository;

    // =========================
    // 1. 프로젝트 생성
    // POST /projects/create
    // =========================
    public ProjectResponseDto createProject(CreateProjectRequestDto request) {

        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다."));

        Project project = Project.builder()
                .company(company)
                .title(request.getTitle())
                .description(request.getDescription())
                .status(ProjectStatus.ACTIVE)
                .build();

        return toDto(projectRepository.save(project));
    }

    // =========================
    // 2. 프로젝트 목록
    // GET /projects/list
    // =========================
    public List<ProjectResponseDto> getProjectList() {

        return projectRepository.findAll()
                .stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    // =========================
    // 3. 프로젝트 상세
    // GET /projects/detail?pid=2
    // =========================
    public ProjectResponseDto getProjectDetail(Long pid) {

        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        return toDto(project);
    }

    // =========================
    // 4. 프로젝트 전체 수정
    // PUT /projects/update?pid=2
    // =========================
    public ProjectResponseDto updateProject(Long pid, UpdateProjectRequestDto request) {

        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        if (request.getTitle() != null) {
            project.setTitle(request.getTitle());
        }

        if (request.getDescription() != null) {
            project.setDescription(request.getDescription());
        }

        return toDto(projectRepository.save(project));
    }

    // =========================
    // 5. 프로젝트 상태 변경 (삭제 대신 ARCHIVED)
    // PATCH /projects/status?pid=2
    // =========================
    public ProjectResponseDto updateProjectStatus(Long pid, ProjectStatus status) {

        Project project = projectRepository.findById(pid)
                .orElseThrow(() -> new RuntimeException("Project not found"));

        project.setStatus(status);

        return toDto(projectRepository.save(project));
    }

    // =========================
    // DTO 변환
    // =========================
    private ProjectResponseDto toDto(Project project) {

        return ProjectResponseDto.builder()
                .id(project.getId())
                .title(project.getTitle())
                .description(project.getDescription())
                .status(project.getStatus())
                .build();
    }
}