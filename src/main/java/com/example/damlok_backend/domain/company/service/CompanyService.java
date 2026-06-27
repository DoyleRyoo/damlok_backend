package com.example.damlok_backend.domain.company.service;

import com.example.damlok_backend.domain.company.dto.CompanyCreateRequestDto;
import com.example.damlok_backend.domain.company.dto.CompanyResponseDto;
import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.domain.company.repository.CompanyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class CompanyService {

    private final CompanyRepository companyRepository;

    // 회사 생성
    public Long createCompany(CompanyCreateRequestDto dto) {

        Company company = Company.builder()
                .name(dto.getName())
                .domain(dto.getDomain())
                .phone(dto.getPhone())
                .build();

        return companyRepository.save(company).getId();
    }

    // 회사 단건 조회
    public CompanyResponseDto getCompany() {

        Company company = companyRepository.findFirstByOrderByIdAsc()
                .orElseThrow(() -> new IllegalArgumentException("회사 없음"));

        return CompanyResponseDto.from(company);
    }

    // 회사 수정
    public Long updateCompany(Long id, CompanyCreateRequestDto dto) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("회사 없음"));

        company.update(dto.getName(), dto.getDomain(), dto.getPhone());

        return companyRepository.save(company).getId();
    }
}