package com.example.damlok_backend.domain.actionitem.repository;

import com.example.damlok_backend.domain.actionitem.entity.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {
}