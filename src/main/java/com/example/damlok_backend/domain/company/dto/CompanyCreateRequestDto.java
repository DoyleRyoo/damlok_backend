package com.example.damlok_backend.domain.company.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CompanyCreateRequestDto {

    private String name;
    private String domain;
    private String phone;
}