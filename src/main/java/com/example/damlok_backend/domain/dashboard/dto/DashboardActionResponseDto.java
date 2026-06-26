package com.example.damlok_backend.domain.dashboard.dto;

import com.example.damlok_backend.domain.actionitem.enums.ActionItemStatus;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DashboardActionResponseDto {

    private Long actionItemId;

    private String task;

    private ActionItemStatus status;
}