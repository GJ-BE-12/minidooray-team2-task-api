package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.State;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {
    boolean existsByProjectName(String name);
//    Project getByProjectName(String projectName);
//    List<Project> getByState(State state);
//    void deleteByProjectName(String projectName);

    @Query("select p from Project p join p.projectMembers pm where pm.memberId = :memberId")
    List<Project> findAllByMemberId(Long memberId);
}
