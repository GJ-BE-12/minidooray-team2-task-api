package com.shoppingmall.shoppingmall.exception;

public class CommentNotfoundException extends NotFoundException {
    public CommentNotfoundException(Long id) {
        super("Project not found: " + id);;
    }
}
