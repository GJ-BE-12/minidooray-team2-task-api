package com.shoppingmall.shoppingmall.exception;

public class ProjectNotFoundException extends NotFoundException {
    public ProjectNotFoundException(Long id) {
        super("Project not found: " + id);
    }
}
