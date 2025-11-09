package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.Task;
import com.shoppingmall.shoppingmall.exception.CommentNotfoundException;
import com.shoppingmall.shoppingmall.exception.NotFoundException;
import com.shoppingmall.shoppingmall.exception.TaskNotFoundException;
import com.shoppingmall.shoppingmall.repository.CommentRepository;
import com.shoppingmall.shoppingmall.repository.TaskRepository;
import com.shoppingmall.shoppingmall.service.CommentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final TaskRepository taskRepository;

    @Transactional
    @Override
    public Comment create(long memberId, long taskId, String content) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        return commentRepository.save(new Comment(memberId, task, content));
    }

    @Override
    public void update(long memberId, long taskId, long commentId, String content) {
        taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

        Comment comment = commentRepository.getReferenceById(commentId);
        comment.setContent(content);
    }

    @Override
    public void delete(long memberId, long taskId, long commentId) {
        if(!commentRepository.existsById(commentId)){
            throw new CommentNotfoundException(commentId);
        }
        commentRepository.deleteById(commentId);
    }
}
