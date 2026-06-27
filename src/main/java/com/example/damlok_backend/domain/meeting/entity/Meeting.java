package com.example.damlok_backend.domain.meeting.entity;

import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.global.entity.BaseEntity;
import com.example.damlok_backend.domain.participant.entity.MeetingParticipant;
import com.example.damlok_backend.domain.actionitem.entity.ActionItem;
import com.example.damlok_backend.domain.meeting.enums.MeetingStatus;
import com.example.damlok_backend.domain.summary.entity.Summary;

import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.type.SqlTypes;
import lombok.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "meetings")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "meeting_created_at", nullable = false, updatable = false)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "meeting_updated_at"))
})
public class Meeting extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "meeting_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @Column(name = "meeting_title", nullable = false)
    private String title;

    @Column(name = "meeting_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private MeetingStatus status;

    @Column(name = "duration_sec")
    private Long durationSec;

    @Lob
    @Column(name = "meeting_transcript")
    private String transcript;

    @Lob
    @Column(name = "meeting_cleaned_transcript")
    private String cleanedTranscript;

    @Column(name = "meeting_audio_url")
    private String audioUrl;

    @Column(name = "meeting_date", nullable = false)
    private LocalDateTime meetingDate;

    @Column(name = "meeting_started_at")
    private LocalDateTime startedAt;

    @Column(name = "meeting_ended_at")
    private LocalDateTime endedAt;

    @Column(name = "meeting_short_summary")
    private String meetingSummary;
    @JdbcTypeCode(SqlTypes.VECTOR)
    @Column(name = "meeting_embedding", columnDefinition = "vector")
    private float[] embedding;

    @OneToMany(mappedBy = "meeting")
    @Builder.Default
    private List<MeetingParticipant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "meeting")
    @Builder.Default
    private List<ActionItem> actionItems = new ArrayList<>();

    @OneToOne(mappedBy = "meeting", cascade = CascadeType.ALL)
    private Summary summary;
}