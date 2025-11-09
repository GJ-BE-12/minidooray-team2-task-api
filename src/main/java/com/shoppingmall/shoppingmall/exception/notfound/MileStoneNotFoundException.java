package com.shoppingmall.shoppingmall.exception.notfound;

public class MileStoneNotFoundException extends NotFoundException {
    public MileStoneNotFoundException(Long id) {
        super("MileStone not found: " + id);;
    }
}
