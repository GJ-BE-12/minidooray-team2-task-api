package com.shoppingmall.shoppingmall.exception;

public class TaskAlreadyExistException extends AlreadyExistException {
    public TaskAlreadyExistException(Long id) {
        super("Task Already Exist: " + id);
    }
}
