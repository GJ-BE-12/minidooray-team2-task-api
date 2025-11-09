package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.Tag;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TagRepository extends JpaRepository<Tag, Long> {
    /*
    SELECT t
    FROM Tag t
    WHERE t.id IN (:ids)
    AND t.project.id = :projectId
     */
    List<Tag> findAllByIdInAndProjectId(List<Long> ids, Long projectId);

    List<Tag> findAllByProjectId(Long projectId);
    Tag findByIdAndProjectId(Long tagId, Long projectId);
    boolean existsByName(String name);
}
