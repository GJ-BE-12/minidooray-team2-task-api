package com.shoppingmall.shoppingmall.dto.task;

import com.shoppingmall.shoppingmall.entity.Task;

public record TaskListResponse(Long id, String taskTitle){
    public static TaskListResponse from(Task task){
        return new TaskListResponse(task.getId(), task.getTitle());
    }
}