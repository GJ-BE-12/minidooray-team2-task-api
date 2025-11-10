package com.shoppingmall.shoppingmall.dto.project;

import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.State;
import lombok.AllArgsConstructor;
import lombok.Getter;

public record GetProjectResponse(Long id, String projectName, State state){
    public static GetProjectResponse from (Project project){
        return new GetProjectResponse(
                project.getId(),
                project.getProjectName(),
                project.getState()
        );
    }
}
