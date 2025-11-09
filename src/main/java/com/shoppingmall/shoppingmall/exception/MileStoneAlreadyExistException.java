package com.shoppingmall.shoppingmall.exception;

public class MileStoneAlreadyExistException extends AlreadyExistException {
  public MileStoneAlreadyExistException(Long id) {
    super("MileStone Already Exist: " + id);
  }
}
