package com.example.damlok_backend.domain.notion.entity;

import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.global.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Notion extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    private String notionId;

    private String name;

    private String url;
}
