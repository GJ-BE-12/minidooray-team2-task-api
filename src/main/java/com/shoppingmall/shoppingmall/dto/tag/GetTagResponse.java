package com.shoppingmall.shoppingmall.dto.tag;

import com.shoppingmall.shoppingmall.entity.Tag;

public record GetTagResponse(Long id, String tagName) {
    public static GetTagResponse from(Tag tag){
        return new GetTagResponse(tag.getId(), tag.getName());
    }
}