package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.Tag;

import java.util.List;

public interface TagService {
    Tag create(Long projectId, Tag tag);

    List<Tag> getTags(Long projectId);

    Tag update(Long projectId, Long tagId, Tag updatedTag);

    void delete(Long projectId, Long tagId);
}
