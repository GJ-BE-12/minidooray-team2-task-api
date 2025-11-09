package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MileStoneRepository extends JpaRepository<MileStone, Long> {
    List<MileStone> findByProjectId(Long projectId);
    boolean existsByProjectAndName(Project project, String name);
    MileStone findByIdAndProjectId(Long mileStoneId, Long projectId);
}
