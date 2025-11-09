package com.shoppingmall.shoppingmall.exception;

public class TaskNotFoundException extends NotFoundException {
    public TaskNotFoundException(Long id) {
        super("Task not found: " + id);
    }
}
