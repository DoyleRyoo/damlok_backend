package com.example.damlok_backend.domain.user.entity;

import com.example.damlok_backend.domain.company.entity.Company;
import com.example.damlok_backend.global.entity.BaseEntity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    private Company company;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = true)
    private String password;

    private String name;

    private String phone;

    private String department;

    private String role;

    private Boolean status = true;

    private LoginType loginType = LoginType.LOCAL;
}