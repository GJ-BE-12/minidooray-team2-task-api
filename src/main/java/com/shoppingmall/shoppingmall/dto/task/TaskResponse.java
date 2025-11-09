package com.shoppingmall.shoppingmall.dto.task;

import com.shoppingmall.shoppingmall.entity.Comment;
import com.shoppingmall.shoppingmall.entity.Task;

import java.util.List;

public record TaskResponse (TaskResponseProject project, TaskResponseTask task,
                            String milestoneName, List<String> tags, List<String> comments) {
    public static TaskResponse from (Task task){
       return new TaskResponse(
               TaskResponseProject.from(task.getProject()),
               TaskResponseTask.from(task),
               task.getMileStone() != null ? task.getMileStone().getName() : null,
               task.getTaskTags().stream().map(t -> t.getTag().getName()).toList(),
               task.getComments().stream().map(Comment::getContent).toList()
       );
    }
}
