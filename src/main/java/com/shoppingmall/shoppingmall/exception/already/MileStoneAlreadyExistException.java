package com.shoppingmall.shoppingmall.exception.already;

public class MileStoneAlreadyExistException extends AlreadyExistException {
  public MileStoneAlreadyExistException(String name) {
    super("MileStone Already Exist: " + name);
  }
}
