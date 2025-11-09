package com.shoppingmall.shoppingmall.exception.notfound;

public class ProjectNotFoundException extends NotFoundException {
    public ProjectNotFoundException(Long id) {
        super("Project not found: " + id);
    }
}
