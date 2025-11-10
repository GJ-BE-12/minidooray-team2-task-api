package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.ProjectMember;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {
    boolean existsByProjectIdAndMemberId(Long projectId, Long memberId);

    List<ProjectMember> findAllByProjectId(long projectId);
}
