package com.example.damlok_backend.domain.actionitem.dto;

import com.example.damlok_backend.domain.actionitem.enums.ActionItemPriority;
import com.example.damlok_backend.domain.actionitem.enums.ActionItemStatus;
import java.time.LocalDate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ActionItemUpdateRequestDto {
    private Long actionItemId;
    private Long projectMemberId;
    private String task;
    private LocalDate startDate;
    private LocalDate dueDate;
    private ActionItemPriority priority;
    private ActionItemStatus status;
}
