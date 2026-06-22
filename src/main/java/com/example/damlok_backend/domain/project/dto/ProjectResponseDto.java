package com.example.damlok_backend.domain.project.dto;

import com.example.damlok_backend.domain.project.enums.ProjectStatus;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponseDto {

    private Long id;
    private String title;
    private String description;
    private ProjectStatus status;
}