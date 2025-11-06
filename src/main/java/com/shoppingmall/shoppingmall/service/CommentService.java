package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.Comment;

public interface CommentService {
    Comment create(long memberId, long taskId, String content);
    void deleteBy
}
