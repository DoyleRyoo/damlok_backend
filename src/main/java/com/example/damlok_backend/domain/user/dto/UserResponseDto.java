package com.example.damlok_backend.domain.user.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class UserResponseDto {

    private Long id;
    private Long companyId;

    private String email;
    private String name;
    private String phone;
    private String department;

    private String role;
    private Boolean status;
}