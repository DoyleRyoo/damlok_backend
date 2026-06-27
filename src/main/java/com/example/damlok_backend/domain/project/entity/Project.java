package com.example.damlok_backend.domain.project.entity;

import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.global.entity.BaseEntity;
import com.example.damlok_backend.domain.meeting.entity.Meeting;
import com.example.damlok_backend.domain.participant.entity.ProjectParticipant;
import com.example.damlok_backend.domain.project.enums.ProjectStatus;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "projects")
@AttributeOverrides({
        @AttributeOverride(name = "createdAt", column = @Column(name = "project_created_at", nullable = false, updatable = false)),
        @AttributeOverride(name = "updatedAt", column = @Column(name = "project_updated_at"))
})
public class Project extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "project_id")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id", nullable = false)
    private Company company;

    @Column(name = "project_title", nullable = false)
    private String title;

    @Column(name = "project_description", columnDefinition = "text")
    private String description;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Column(name = "project_status", nullable = false)
    @Enumerated(EnumType.STRING)
    private ProjectStatus status;

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    @OneToMany(mappedBy = "project")
    @Builder.Default
    private List<ProjectParticipant> participants = new ArrayList<>();

    @OneToMany(mappedBy = "project")
    @Builder.Default
    private List<Meeting> meetings = new ArrayList<>();
}