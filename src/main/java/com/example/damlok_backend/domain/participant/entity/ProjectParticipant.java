package com.example.damlok_backend.domain.participant.entity;

import com.example.damlok_backend.domain.participant.enums.ProjectMemberGrade;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberRole;
import com.example.damlok_backend.domain.participant.enums.ProjectMemberStatus;
import com.example.damlok_backend.domain.project.entity.Project;
import com.example.damlok_backend.domain.user.entity.User;
import com.example.damlok_backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "project_participant")
public class ProjectParticipant extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private ProjectMemberRole role;
    
    @Enumerated(EnumType.STRING)
    private ProjectMemberStatus status;
    
    @Enumerated(EnumType.STRING)
    private ProjectMemberGrade grade;
}