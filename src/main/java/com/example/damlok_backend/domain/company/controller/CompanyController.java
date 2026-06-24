package com.example.damlok_backend.domain.company.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.damlok_backend.domain.company.dto.CompanyCreateRequestDto;
import com.example.damlok_backend.domain.company.dto.CompanyResponseDto;
import com.example.damlok_backend.domain.company.service.CompanyService;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/company")
@RequiredArgsConstructor
public class CompanyController {

    private final CompanyService companyService;

    // company001 - 회사 등록
    @PostMapping("/regist")
    public ResponseEntity<Long> createCompany(@RequestBody CompanyCreateRequestDto dto) {
        return ResponseEntity.ok(companyService.createCompany(dto));
    }

    // company003 - 회사 조회
    @GetMapping
    public ResponseEntity<CompanyResponseDto> getCompany(@RequestParam Long id) {
        return ResponseEntity.ok(companyService.getCompany(id));
    }

    // company002 - 회사 수정 
    @PatchMapping("/update")
    public ResponseEntity<Long> updateCompany(@RequestParam Long id,
                                              @RequestBody CompanyCreateRequestDto dto) {
        return ResponseEntity.ok(companyService.updateCompany(id, dto));
    }
}