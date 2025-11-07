package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.MileStone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MileStoneRepository extends JpaRepository<MileStone, Long> {
    boolean existsByName(String name);
}
