package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.Task;

public interface CommentService {
    Comment create(long memberId, long taskId, String content);
    void deleteComment(long memberId, long commentId);
}
