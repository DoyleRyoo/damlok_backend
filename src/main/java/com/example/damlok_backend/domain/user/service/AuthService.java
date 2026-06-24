package com.example.damlok_backend.domain.user.service;

import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.domain.company.repository.CompanyRepository;
import com.example.damlok_backend.domain.user.dto.LoginRequestDto;
import com.example.damlok_backend.domain.user.dto.SignUpRequestDto;
import com.example.damlok_backend.domain.user.entity.User;
import com.example.damlok_backend.domain.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {

    private final UserRepository userRepository;
    private final CompanyRepository companyRepository;

    // 회원가입
    public void signUp(SignUpRequestDto request) {

        // 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new IllegalArgumentException("이미 사용 중인 이메일입니다.");
        }

        // 회사 조회
        Company company = companyRepository.findById(request.getCompanyId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 회사입니다."));

        // 사용자 생성
        User user = User.builder()
                .company(company)
                .email(request.getEmail())
                .password(request.getPassword()) 
                .name(request.getName())
                .phone(request.getPhone())
                .department(request.getDepartment())
                .role(request.getRole())
                .status(true)
                .build();

        userRepository.save(user);
    }

    // 로그인
    public Long login(LoginRequestDto request) {

        User user = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 이메일입니다."));

        if (!user.getPassword().equals(request.getPassword())) {
            throw new IllegalArgumentException("비밀번호가 일치하지 않습니다.");
        }

        return user.getId();
    }
}