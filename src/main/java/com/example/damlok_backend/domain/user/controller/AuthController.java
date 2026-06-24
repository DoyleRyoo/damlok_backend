package com.example.damlok_backend.domain.user.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.damlok_backend.domain.user.dto.LoginRequestDto;
import com.example.damlok_backend.domain.user.dto.SignUpRequestDto;
import com.example.damlok_backend.domain.user.service.AuthService;

import jakarta.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    // 회원가입
    @PostMapping("/signup")
    public ResponseEntity<String> signUp(@RequestBody SignUpRequestDto request) {

        authService.signUp(request);

        return ResponseEntity.ok("회원가입 성공");
    }

    // 로그인
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequestDto request,
                                HttpSession session) {

        Long userId = authService.login(request);

        session.setAttribute("userId", userId);

        return ResponseEntity.ok(
                "로그인 성공 (userId=" + userId + ")"
        );
    }

    // 로그아웃
    @PostMapping("/logout")
    public ResponseEntity<String> logout(HttpSession session) {

        session.invalidate();

        return ResponseEntity.ok("로그아웃 성공");
    }
}
