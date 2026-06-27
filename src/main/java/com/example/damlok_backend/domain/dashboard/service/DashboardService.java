package com.example.damlok_backend.domain.dashboard.service;

import com.example.damlok_backend.domain.actionitem.entity.ActionItem;
import com.example.damlok_backend.domain.actionitem.repository.ActionItemRepository;
import com.example.damlok_backend.domain.dashboard.dto.DashboardActionResponseDto;
import com.example.damlok_backend.domain.dashboard.dto.DashboardMeetingResponseDto;
import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;
import com.example.damlok_backend.domain.participant.repository.MeetingParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DashboardService {

    private final MeetingParticipantRepository meetingParticipantRepository;
    private final ActionItemRepository actionItemRepository;

    public List<DashboardMeetingResponseDto> getRecentMeetings(Long userId) {

        List<MeetingParticipant> meetingParticipants =
                meetingParticipantRepository.findWithMeetingByProjectParticipantUserId(userId);

        return meetingParticipants.stream()
                .map(meetingParticipant -> DashboardMeetingResponseDto.builder()
                        .meetingId(meetingParticipant.getMeeting().getId())
                        .title(meetingParticipant.getMeeting().getTitle())
                        .summary(meetingParticipant.getMeeting().getMeetingSummary())
                        .build())
                .toList();
    }

    public List<DashboardActionResponseDto> getRecentActions(Long userId) {

    List<ActionItem> actionItems =
            actionItemRepository.findWithAssigneeByAssigneeUserId(userId);

    return actionItems.stream()
            .map(actionItem -> DashboardActionResponseDto.builder()
                    .actionItemId(actionItem.getId())
                    .task(actionItem.getTask())
                    .status(actionItem.getStatus())
                    .build())
            .toList();
        }
}