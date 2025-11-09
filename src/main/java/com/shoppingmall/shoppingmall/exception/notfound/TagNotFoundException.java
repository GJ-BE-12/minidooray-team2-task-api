package com.shoppingmall.shoppingmall.exception.notfound;

public class TagNotFoundException extends NotFoundException {
  public TagNotFoundException(Long id) {
    super("Tag not found: " + id);;
  }
}
