package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController{

    private final ProjectService projectService;

    @PostMapping
    public Project create(@RequestHeader("memberId") Long memberId,
                          @RequestBody Project project) {
        return projectService.create(project.getProjectName(), memberId, project.getTags());
    }

    @GetMapping("/by-member/{memberId}")
    public List<Project> getProjects(@PathVariable("memberId") Long memberId){
        return projectService.getProjectsByMemberId(memberId);
    }


}
