package com.example.damlok_backend.domain.notion.repository;

import com.example.damlok_backend.domain.notion.entity.Notion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NotionRepository extends JpaRepository<Notion, Long> {
}