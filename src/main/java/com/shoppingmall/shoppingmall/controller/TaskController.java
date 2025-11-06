package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.dto.CreateTaskRequest;
import com.shoppingmall.shoppingmall.entity.Task;
import com.shoppingmall.shoppingmall.service.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class TaskController {

    private final TaskService taskService;

    @PostMapping("/api/projects/{id}/tasks")
    public Task create(@PathVariable("id") Long projectId,
                       @RequestBody CreateTaskRequest createTaskRequest){
        return taskService.create(projectId, createTaskRequest.getTitle(), createTaskRequest.getContent());
    }

}
