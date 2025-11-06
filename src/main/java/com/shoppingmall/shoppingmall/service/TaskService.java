package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.Task;

public interface TaskService {
    Task create(Long projectId, String title, String conte);
}
