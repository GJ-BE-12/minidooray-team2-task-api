package com.shoppingmall.shoppingmall.exception.notfound;

public class CommentNotfoundException extends NotFoundException {
    public CommentNotfoundException(Long id) {
        super("Project not found: " + id);;
    }
}
