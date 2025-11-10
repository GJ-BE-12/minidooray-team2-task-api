package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.dto.tag.CreateTagRequest;
import com.shoppingmall.shoppingmall.entity.Tag;

import java.util.List;

public interface TagService {
    Tag create(long projectId, CreateTagRequest createTagRequest);
    List<Tag> getTags(Long projectId);
    void deleteTag(Long projectId, Long tagId);
    void updateTag(Long projectId, Long tagId, CreateTagRequest updatedTag);

}
