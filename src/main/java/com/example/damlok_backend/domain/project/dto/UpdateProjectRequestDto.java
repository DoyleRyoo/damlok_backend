package com.example.damlok_backend.domain.project.dto;

import com.example.damlok_backend.domain.project.enums.ProjectStatus;
import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UpdateProjectRequestDto {

    private String title;

    @JsonAlias("description")
    private String content;

    private ProjectStatus status;
}
