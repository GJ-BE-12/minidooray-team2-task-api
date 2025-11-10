package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.dto.TaskTagResponse;
import com.shoppingmall.shoppingmall.dto.comment.CommentRequest;
import com.shoppingmall.shoppingmall.dto.mileStone.GetMileStoneResponse;
import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.service.TaskInfoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/projects/{projectId}/tasks/{taskId}")
public class TaskInfoController {

    private final TaskInfoService taskInfoService;

    @GetMapping("/tags")
    public ResponseEntity<List<TaskTagResponse>> getTaskTag(@PathVariable("projectId") Long projectId,
                                                            @PathVariable("taskId") Long taskId){
        List<TaskTagResponse> taskTags = taskInfoService.getTaskTags(projectId, taskId)
                .stream()
                .map(TaskTagResponse::from)
                .toList();

        return ResponseEntity.ok().body(taskTags);
    }

    @GetMapping("/milestones")
    public ResponseEntity<GetMileStoneResponse> getTaskMileStone(@PathVariable("projectId") Long projectId,
                                                                 @PathVariable("taskId") Long taskId){
        MileStone mileStone = taskInfoService.getTaskMileStone(projectId, taskId);
        return ResponseEntity.ok().body(GetMileStoneResponse.from(mileStone));
    }

    @GetMapping("/comments")
    public ResponseEntity<List<CommentRequest>> getComments(@PathVariable("projectId") Long projectId,
                                                  @PathVariable("taskId") Long taskId){
        List<Comment> comments = taskInfoService.getTaskComments(projectId, taskId);
        List<CommentRequest> dtoList = new ArrayList<>();
        for(Comment comment : comments){
            CommentRequest commentRequest = new CommentRequest(comment.getId(), comment.getContent());
            dtoList.add(commentRequest);
        }
        return ResponseEntity.ok().body(dtoList);
    }
}

