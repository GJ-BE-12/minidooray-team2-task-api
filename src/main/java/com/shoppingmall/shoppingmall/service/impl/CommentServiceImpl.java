package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.Task;
import com.shoppingmall.shoppingmall.exception.notfound.CommentNotfoundException;
import com.shoppingmall.shoppingmall.exception.notfound.TaskNotFoundException;
import com.shoppingmall.shoppingmall.repository.CommentRepository;
import com.shoppingmall.shoppingmall.repository.TaskRepository;
import com.shoppingmall.shoppingmall.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Override
    public Comment create(long memberId, long taskId, String content) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        return commentRepository.save(new Comment(memberId, task, content));
    }

    @Transactional
    @Override
    public void update(long memberId, long taskId, long commentId, String content) {
        taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        Comment comment = commentRepository.getReferenceById(commentId);
        comment.setContent(content);
    }

    @Transactional
    @Override
    public void delete(long memberId, long taskId, long commentId) {
        if(!commentRepository.existsById(commentId)){
            throw new CommentNotfoundException(commentId);
        }
        commentRepository.deleteById(commentId);
    }
}
