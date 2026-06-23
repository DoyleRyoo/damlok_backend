package com.example.damlok_backend.domain.company.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyListResponseDto {

    private Long id;
    private String name;
    private String domain;
}