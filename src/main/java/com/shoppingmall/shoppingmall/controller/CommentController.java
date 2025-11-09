package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class CommentController {

    private final CommentService commentService;
    @PostMapping("/{projectId}/tasks/{taskId}/comments")
    public ResponseEntity<Comment> register(@PathVariable Long projectId,
                                            @PathVariable Long taskId,
                                            @RequestHeader("memberId") Long memberId,
                                            @RequestBody String content){
        Comment comment = commentService.create(memberId, taskId, content);
        return ResponseEntity.ok().body(comment);
    }
}
