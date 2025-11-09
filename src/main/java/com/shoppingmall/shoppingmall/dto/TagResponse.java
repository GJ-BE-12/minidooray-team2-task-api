package com.shoppingmall.shoppingmall.dto;

import com.shoppingmall.shoppingmall.entity.Tag;

public record TagResponse(Long id, String name) {
    public static TagResponse from(Tag tag){
        return new TagResponse(tag.getId(), tag.getName());
    }
}
