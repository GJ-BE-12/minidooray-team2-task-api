package com.shoppingmall.shoppingmall.exception;

public class TagNotFoundException extends NotFoundException {
  public TagNotFoundException(Long id) {
    super("Tag not found: " + id);;
  }
}
