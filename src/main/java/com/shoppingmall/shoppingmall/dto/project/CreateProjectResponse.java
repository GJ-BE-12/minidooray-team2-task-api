package com.shoppingmall.shoppingmall.dto.project;

import com.shoppingmall.shoppingmall.entity.Project;

public record CreateProjectResponse(Long id){
    public static CreateProjectResponse from (Project project){
        return new CreateProjectResponse(
                project.getId()
        );
    }
}
