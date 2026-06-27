package com.example.damlok_backend.domain.project.dto;

import com.example.damlok_backend.domain.project.enums.ProjectStatus;

import java.time.LocalDateTime;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ProjectResponseDto {

    private Long id;
    private String title;
    private String content;
    private ProjectStatus status;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
