package com.example.damlok_backend.domain.summary.entity;

import com.example.damlok_backend.domain.meeting.entity.Meeting;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "full_summaries")
@EntityListeners(AuditingEntityListener.class)
public class Summary {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "summary_id")
    private Long id;

    @CreatedDate
    @Column(name = "summary_created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    @Column(name = "summary_objective", nullable = false, columnDefinition = "text")
    private String objective;


    @Column(name = "summary_decision", nullable = false, columnDefinition = "text")
    private String decision;

    @Column(name = "summary_notion_page_id")
    private String notionPageId;

    @Column(name = "summary_notion_page_url")
    private String notionPageUrl;
}
