package com.example.damlok_backend.domain.actionitem.repository;

import com.example.damlok_backend.domain.actionitem.entity.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {

    List<ActionItem> findByMeetingId(Long meetingId);
    List<ActionItem> findByAssigneeUserId(Long userId);
}