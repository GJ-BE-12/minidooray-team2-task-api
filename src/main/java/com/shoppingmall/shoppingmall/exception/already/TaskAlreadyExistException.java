package com.shoppingmall.shoppingmall.exception.already;

public class TaskAlreadyExistException extends AlreadyExistException {
    public TaskAlreadyExistException(Long id) {
        super("Task Already Exist: " + id);
    }
}
