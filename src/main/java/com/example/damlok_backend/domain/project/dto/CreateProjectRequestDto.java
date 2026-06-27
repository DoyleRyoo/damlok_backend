package com.example.damlok_backend.domain.project.dto;

import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequestDto {

    @NotBlank(message = "Project title is required.")
    private String title;

    @NotBlank(message = "Project content is required.")
    @JsonAlias("description")
    private String content;

    private ProjectStatus status;
}
