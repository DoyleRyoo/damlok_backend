package com.example.damlok_backend.domain.user.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpRequestDto {

    @NotNull
    private Long companyId;

    @Email
    @NotBlank
    private String email;

    @NotBlank
    private String name;
    private String phone;
    @NotBlank
    private String department;
    @NotBlank
    private String role;
}
