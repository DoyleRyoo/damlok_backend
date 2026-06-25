package com.example.damlok_backend.domain.dashboard.service;

import com.example.damlok_backend.domain.dashboard.dto.DashboardMeetingResponseDto;
import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;
import com.example.damlok_backend.domain.participant.repository.MeetingParticipantRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DashboardService {

    private final MeetingParticipantRepository meetingParticipantRepository;

    public List<DashboardMeetingResponseDto> getRecentMeetings(Long userId) {

        List<MeetingParticipant> meetingParticipants =
                meetingParticipantRepository.findByProjectParticipantUserId(userId);

        return meetingParticipants.stream()
                .map(meetingParticipant -> DashboardMeetingResponseDto.builder()
                        .meetingId(meetingParticipant.getMeeting().getId())
                        .title(meetingParticipant.getMeeting().getTitle())
                        .summary(meetingParticipant.getMeeting().getMeetingSummary())
                        .build())
                .toList();
    }
}