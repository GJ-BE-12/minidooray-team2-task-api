package com.shoppingmall.shoppingmall.exception.already;

public class ProjectAlreadyExistException extends AlreadyExistException {
    public ProjectAlreadyExistException(String name) {
        super("Project Already Exist: " + name);
    }
}
