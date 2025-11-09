package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.Task;

public interface CommentService {
    Comment create(long memberId, long taskId, String content);
    void update(long memberId, long taskId, long commentId, String content);
    void delete(long memberId, long taskId, long commentId);
}
