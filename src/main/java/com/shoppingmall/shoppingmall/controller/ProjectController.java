package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.ProjectMember;
import com.shoppingmall.shoppingmall.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/projects")
public class ProjectController{

    private final ProjectService projectService;

    // 프로젝트 이름과 멤버아이디(header로 들어옴, adminId에 memberId 삽입) 상태는 디폴트 값으로 ACTIVATE 부여
    @PostMapping
    public Project create(@RequestHeader("memberId") Long memberId,
                          @RequestBody Project project) {
        return projectService.create(project.getProjectName(), memberId, project.getTags(), project.getMileStones());
    }

    // memberId에 해당하는 member가 가지고 있는 Project List를 보여줌
    @GetMapping("/by-member/{memberId}")
    public List<Project> getProjects(@PathVariable("memberId") Long memberId){
        return projectService.getProjectsByMemberId(memberId);
    }

    // uri로 들어온 ProjectId에 해당하는 프로젝트에 memberId를 저장함
    @PostMapping("/{id}/members")
    public ResponseEntity<ProjectMember> createProjectMember(@PathVariable("id") Long projectId,
                                                             @RequestBody Long memberId){
        ProjectMember projectMember = projectService.addMemberToProject(projectId, memberId);

        return ResponseEntity.ok().body(projectMember);
    }


}
