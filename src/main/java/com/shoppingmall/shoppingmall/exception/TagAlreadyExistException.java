package com.shoppingmall.shoppingmall.exception;

public class TagAlreadyExistException extends AlreadyExistException {
    public TagAlreadyExistException(Long id) {
        super("Tag Already Exist: " + id);
    }
}
