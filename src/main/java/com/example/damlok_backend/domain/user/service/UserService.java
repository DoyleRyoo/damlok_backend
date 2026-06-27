package com.example.damlok_backend.domain.user.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.damlok_backend.domain.user.dto.UserListResponseDto;
import com.example.damlok_backend.domain.user.dto.UserResponseDto;
import com.example.damlok_backend.domain.user.dto.UserUpdateRequestDto;
import com.example.damlok_backend.domain.user.entity.User;
import com.example.damlok_backend.domain.user.repository.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserService {

    private final UserRepository userRepository;

    // users001 - 유저 목록 조회
    public List<UserListResponseDto> getUserList() {

    return userRepository.findAll().stream()
            .map(user -> UserListResponseDto.builder()
                    .id(user.getId())
                    .email(user.getEmail())
                    .name(user.getName())
                    .phone(user.getPhone())
                    .department(user.getDepartment())
                    .role(user.getRole())
                    .build())
            .toList();
}

    // 유저 상세 조회
    public UserResponseDto getUserDetail(Long uid) {

    User user = userRepository.findById(uid)
            .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

    return UserResponseDto.builder()
            .id(user.getId())
            .email(user.getEmail())
            .name(user.getName())
            .phone(user.getPhone())
            .department(user.getDepartment())
            .role(user.getRole())
            .status(user.getStatus())
            .build();
        }

        // 유저 수정
        @Transactional
        public Long updateUser(Long uid, UserUpdateRequestDto dto) {
        User user = userRepository.findById(uid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        user.setName(dto.getName());
        user.setPhone(dto.getPhone());
        user.setDepartment(dto.getDepartment());
        user.setRole(dto.getRole());

        return user.getId();
        }

        // 유저 삭제(상태 변경)
        @Transactional
        public Long deleteUser(Long uid) {

        User user = userRepository.findById(uid)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 유저입니다."));

        user.setStatus(false);   // 상태만 false로 변경

        userRepository.save(user);

        return user.getId();
        }
}