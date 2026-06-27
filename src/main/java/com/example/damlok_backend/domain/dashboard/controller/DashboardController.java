package com.example.damlok_backend.domain.dashboard.controller;

import com.example.damlok_backend.domain.dashboard.dto.DashboardActionResponseDto;
import com.example.damlok_backend.domain.dashboard.dto.DashboardMeetingResponseDto;
import com.example.damlok_backend.domain.dashboard.service.DashboardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/dashboard")
@RequiredArgsConstructor
public class DashboardController {

    private final DashboardService dashboardService;

    @GetMapping("/meetings")
    public ResponseEntity<List<DashboardMeetingResponseDto>> getRecentMeetings(
            @RequestParam Long uid
    ) {

        return ResponseEntity.ok(
                dashboardService.getRecentMeetings(uid)
        );
    }

    @GetMapping("/actions")
    public ResponseEntity<List<DashboardActionResponseDto>> getRecentActions(
            @RequestParam Long uid
    ) {

        return ResponseEntity.ok(
            dashboardService.getRecentActions(uid)
        );
    }
}