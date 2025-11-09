package com.shoppingmall.shoppingmall.exception;

public class MileStoneNotFoundException extends NotFoundException {
    public MileStoneNotFoundException(Long id) {
        super("MileStone not found: " + id);;
    }
}
