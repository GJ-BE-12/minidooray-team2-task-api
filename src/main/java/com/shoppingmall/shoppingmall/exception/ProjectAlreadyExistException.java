package com.shoppingmall.shoppingmall.exception;

public class ProjectAlreadyExistException extends AlreadyExistException {
    public ProjectAlreadyExistException(Long id) {
        super("Project Already Exist: " + id);
    }
}
