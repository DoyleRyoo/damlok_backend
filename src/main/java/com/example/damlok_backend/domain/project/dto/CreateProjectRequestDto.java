package com.example.damlok_backend.domain.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequestDto {

    private Long companyId;
    private String title;
    private String description;
}