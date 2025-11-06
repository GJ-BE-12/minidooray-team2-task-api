package com.shoppingmall.shoppingmall.repository;

import com.shoppingmall.shoppingmall.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
