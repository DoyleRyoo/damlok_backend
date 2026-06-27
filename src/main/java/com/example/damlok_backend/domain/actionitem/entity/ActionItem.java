package com.example.damlok_backend.domain.actionitem.entity;

import com.example.damlok_backend.domain.actionitem.enums.ActionItemPriority;
import com.example.damlok_backend.domain.actionitem.enums.ActionItemStatus;
import com.example.damlok_backend.domain.meeting.entity.Meeting;
import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import com.example.damlok_backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "action_items")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "action_item_created_at", nullable = false, updatable = false)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "action_item_updated_at"))
})
public class ActionItem extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "action_item_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meeting_id", nullable = false)
    private Meeting meeting;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_member_id", nullable = false)
    private ProjectParticipant assignee;

    @Column(name = "assignee_name")
    private String assigneeName;

    @Column(name = "assignee_email")
    private String assigneeEmail;

    @Column(name = "action_item_task", nullable = false, columnDefinition = "text")
    private String task;

    @Column(name = "action_item_start_date", nullable = false)
    private LocalDate startDate;

    @Column(name = "action_item_due_date", nullable = false)
    private LocalDate dueDate;

    @Column(name = "action_item_priority", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActionItemPriority priority;

    @Column(name = "action_item_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ActionItemStatus status;

    @Column(name = "action_item_notion_page_id")
    private String notionPageId;

    @Column(name = "action_item_notion_page_url", columnDefinition = "text")
    private String notionPageUrl;
}