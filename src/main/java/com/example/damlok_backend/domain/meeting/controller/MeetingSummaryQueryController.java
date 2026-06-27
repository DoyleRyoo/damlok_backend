package com.example.damlok_backend.domain.meeting.controller;

import com.example.damlok_backend.domain.actionitem.dto.ActionItemResponseDto;
import com.example.damlok_backend.domain.actionitem.service.ActionItemService;
import com.example.damlok_backend.domain.summary.dto.ShortSummaryResponseDto;
import com.example.damlok_backend.domain.summary.dto.SummaryResponseDto;
import com.example.damlok_backend.domain.summary.service.SummaryService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meetings")
@RequiredArgsConstructor
public class MeetingSummaryQueryController {

    private final SummaryService summaryService;
    private final ActionItemService actionItemService;

    @GetMapping("/full")
    public ResponseEntity<SummaryResponseDto> getFullSummary(
            @RequestParam Long mid
    ) {
        return ResponseEntity.ok(summaryService.getFullSummary(mid));
    }

    @GetMapping("/short")
    public ResponseEntity<ShortSummaryResponseDto> getShortSummary(
            @RequestParam Long mid
    ) {
        return ResponseEntity.ok(summaryService.getShortSummary(mid));
    }

    @GetMapping("/action")
    public ResponseEntity<List<ActionItemResponseDto>> getActionItems(
            @RequestParam Long mid
    ) {
        return ResponseEntity.ok(actionItemService.getActionItems(mid));
    }
}
