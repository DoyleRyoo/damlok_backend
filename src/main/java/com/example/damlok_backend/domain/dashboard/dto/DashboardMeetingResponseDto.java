package com.example.damlok_backend.domain.dashboard.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DashboardMeetingResponseDto {

    private Long meetingId;

    private String title;

    private String summary;
}