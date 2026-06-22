package com.example.damlok_backend.domain.project.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CreateProjectRequestDto {

    private String title;
    private String description;
}