package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.dto.task.CreateTaskRequest;
import com.shoppingmall.shoppingmall.dto.task.UpdateTaskRequest;
import com.shoppingmall.shoppingmall.entity.Task;

import java.util.List;

public interface TaskService {
    Task create(long projectId, CreateTaskRequest createTaskRequest);
    List<Task> getTasksByProject(Long projectId);
    Task getTask(Long projectId, Long taskId);
    void deleteTask(Long projectId, Long taskId);
    void updateTask(Long projectId, Long taskId, UpdateTaskRequest updateTaskRequest);
    //TaskCreationOptionsResponse getTasksByProject(Long projectId);

}
