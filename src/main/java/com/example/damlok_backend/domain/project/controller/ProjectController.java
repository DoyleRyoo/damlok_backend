package com.example.damlok_backend.domain.project.controller;

import com.example.damlok_backend.domain.project.dto.CreateProjectRequestDto;
import com.example.damlok_backend.domain.project.dto.ProjectResponseDto;
import com.example.damlok_backend.domain.project.dto.UpdateProjectRequestDto;
import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.example.damlok_backend.domain.project.service.ProjectService;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    // =========================
    // 1. 프로젝트 생성
    // POST /projects/create
    // =========================
    @PostMapping("/create")
    public ProjectResponseDto createProject(@RequestBody CreateProjectRequestDto request) {
        return projectService.createProject(request);
    }

    // =========================
    // 2. 프로젝트 목록
    // GET /projects/list
    // =========================
    @GetMapping("/list")
    public List<ProjectResponseDto> getProjectList() {
        return projectService.getProjectList();
    }

    // =========================
    // 3. 프로젝트 상세
    // GET /projects/detail?pid=1
    // =========================
    @GetMapping("/detail")
    public ProjectResponseDto getProjectDetail(@RequestParam Long pid) {
        return projectService.getProjectDetail(pid);
    }

    // =========================
    // 4. 프로젝트 전체 수정
    // PUT /projects/update?pid=1
    // =========================
    @PutMapping("/update")
    public ProjectResponseDto updateProject(
            @RequestParam Long pid,
            @RequestBody UpdateProjectRequestDto request
    ) {
        return projectService.updateProject(pid, request);
    }

    // =========================
    // 5. 프로젝트 상태 변경 (삭제 대신 ARCHIVED)
    // PATCH /projects/status?pid=1
    // =========================
    @PatchMapping("/status")
    public ProjectResponseDto updateStatus(
            @RequestParam Long pid,
            @RequestParam ProjectStatus status
    ) {
        return projectService.updateProjectStatus(pid, status);
    }
}