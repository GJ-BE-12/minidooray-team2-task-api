package com.shoppingmall.shoppingmall.dto.task;

import com.shoppingmall.shoppingmall.entity.Project;

public record TaskResponseProject(Long id, String name) {
    public static TaskResponseProject from(Project project){
        return new TaskResponseProject(project.getId(), project.getProjectName());
    }
}
