package com.shoppingmall.shoppingmall.exception.already;

public class TagAlreadyExistException extends AlreadyExistException {
    public TagAlreadyExistException(String name) {
        super("Tag Already Exist: " + name);
    }
}
