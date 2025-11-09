package com.shoppingmall.shoppingmall.exception;

public class CommentAlreadyExistException extends AlreadyExistException {
    public CommentAlreadyExistException(Long id) {
        super("Comment Already Exist: " + id);
    }
}
