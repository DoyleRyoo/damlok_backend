package com.example.damlok_backend.domain.user.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.damlok_backend.domain.user.dto.UserListResponseDto;
import com.example.damlok_backend.domain.user.dto.UserResponseDto;
import com.example.damlok_backend.domain.user.dto.UserUpdateRequestDto;
import com.example.damlok_backend.domain.user.service.UserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    // users001 - 유저 목록 조회
    @GetMapping("/list")
    public ResponseEntity<List<UserListResponseDto>> getUserList() {
        return ResponseEntity.ok(userService.getUserList());
    }
    
    // 유저 상세 조회
    @GetMapping("/detail")
    public ResponseEntity<UserResponseDto> getUserDetail(
            @RequestParam Long uid) {

        return ResponseEntity.ok(userService.getUserDetail(uid));
    }

    // 유저 수정
    @PutMapping("/update")
    public ResponseEntity<Long> updateUser(
            @RequestParam Long uid,
            @RequestBody UserUpdateRequestDto dto) {

        return ResponseEntity.ok(userService.updateUser(uid, dto));
    }

    // 유저 삭제(상태 변경)
    @PatchMapping("/status")
    public ResponseEntity<Long> deleteUser(@RequestParam Long uid) {

        return ResponseEntity.ok(userService.deleteUser(uid));
    }
}