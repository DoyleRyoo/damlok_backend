package com.example.damlok_backend.domain.user.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateRequestDto {

    private String name;
    private String phone;
    private String department;
    private String role;
}