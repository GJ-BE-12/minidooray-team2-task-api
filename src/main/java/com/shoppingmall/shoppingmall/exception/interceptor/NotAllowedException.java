package com.shoppingmall.shoppingmall.exception.interceptor;

public class NotAllowedException extends RuntimeException {
    public NotAllowedException(String message) {
        super(message);
    }
}
