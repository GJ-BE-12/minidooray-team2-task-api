package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.dto.CreateTagRequest;
import com.shoppingmall.shoppingmall.entity.Tag;

import java.util.List;

public interface TagService {
    Tag create(Long projectId, CreateTagRequest createTagRequest);
    List<Tag> getTags(Long projectId);
    void deleteTag(Long projectId, Long tagId);

    Tag update(Long projectId, Long tagId, Tag updatedTag);

}
