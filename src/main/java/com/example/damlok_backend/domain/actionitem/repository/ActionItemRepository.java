package com.example.damlok_backend.domain.actionitem.repository;

import com.example.damlok_backend.domain.actionitem.entity.ActionItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ActionItemRepository extends JpaRepository<ActionItem, Long> {

    List<ActionItem> findByMeetingId(Long meetingId);
    @Query("""
            select ai
            from ActionItem ai
            join fetch ai.assignee assignee
            join fetch assignee.user user
            where user.id = ?1
            order by ai.createdAt desc
            """)
    List<ActionItem> findWithAssigneeByAssigneeUserId(Long userId);

    List<ActionItem> findByAssigneeUserId(Long userId);
}