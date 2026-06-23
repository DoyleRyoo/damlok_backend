package com.example.damlok_backend.domain.company.dto;

import com.example.damlok_backend.domain.company.entity.Company;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class CompanyResponseDto {

    private Long id;
    private String name;
    private String domain;
    private String phone;

    public static CompanyResponseDto from(Company company) {
        return CompanyResponseDto.builder()
                .id(company.getId())
                .name(company.getName())
                .domain(company.getDomain())
                .phone(company.getPhone())
                .build();
    }
}