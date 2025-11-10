package com.shoppingmall.shoppingmall.exception.interceptor;

public class MissingHeaderException extends RuntimeException {
    public MissingHeaderException(String message) {
        super(message);
    }
}
