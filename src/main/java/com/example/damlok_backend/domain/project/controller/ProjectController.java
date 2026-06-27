package com.example.damlok_backend.domain.project.controller;

import com.example.damlok_backend.domain.project.dto.CreateProjectRequestDto;
import com.example.damlok_backend.domain.project.dto.ProjectResponseDto;
import com.example.damlok_backend.domain.project.dto.UpdateProjectRequestDto;
import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.example.damlok_backend.domain.project.service.ProjectService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@RequiredArgsConstructor
public class ProjectController {

    private final ProjectService projectService;

    @PostMapping("/create")
    public ProjectResponseDto createProject(@Valid @RequestBody CreateProjectRequestDto request) {
        return projectService.createProject(request);
    }

    @GetMapping("/list")
    public List<ProjectResponseDto> getProjectList() {
        return projectService.getProjectList();
    }

    @GetMapping("/detail")
    public ProjectResponseDto getProjectDetail(@RequestParam Long pid) {
        return projectService.getProjectDetail(pid);
    }

    @PutMapping("/update")
    public ProjectResponseDto updateProject(
            @RequestParam Long pid,
            @Valid @RequestBody UpdateProjectRequestDto request
    ) {
        return projectService.updateProject(pid, request);
    }

    @PatchMapping("/status")
    public ProjectResponseDto updateStatus(@RequestParam Long pid) {
        return projectService.archiveProject(pid);
    }
}
