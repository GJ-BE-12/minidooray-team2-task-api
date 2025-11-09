package com.shoppingmall.shoppingmall.dto.task;

import com.shoppingmall.shoppingmall.entity.Task;

public record TaskResponseTask(String title, String content) {
    public static TaskResponseTask from(Task task){
        return new TaskResponseTask(task.getTitle(), task.getContent());
    }
}
