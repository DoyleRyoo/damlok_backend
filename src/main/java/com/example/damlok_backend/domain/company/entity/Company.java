package com.example.damlok_backend.domain.company.entity;

import com.example.damlok_backend.global.entity.BaseEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.example.damlok_backend.domain.user.entity.*;
import com.example.damlok_backend.domain.project.entity.*;
import com.example.damlok_backend.domain.notion.entity.*;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Company extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String domain;
    private String phone;

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @Builder.Default
    @JsonIgnore
    private List<User> users = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Project> projects = new ArrayList<>();

    @OneToMany(mappedBy = "company", fetch = FetchType.LAZY)
    @Builder.Default
    private List<Notion> notions = new ArrayList<>();
    
    public void update(String name, String domain, String phone) {
        this.name = name;
        this.domain = domain;
        this.phone = phone;
    }
}