package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.ProjectMember;
import com.shoppingmall.shoppingmall.entity.State;
import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import com.shoppingmall.shoppingmall.service.ProjectService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    @Transactional
    @Override
    public Project create(String name, Long memberId, List<Tag> tags) {
        if(projectRepository.existsByProjectName(name)){
            throw new IllegalStateException("Project(name = " + name + ") already exists.");
        }
        Project project = new Project(name, memberId);
        ProjectMember adminMember = new ProjectMember(memberId);

        project.addProjectMember(adminMember);

        if (tags != null && !tags.isEmpty()) {
            project.setTags(tags);
        }

        return projectRepository.save(project);
    }

    @Transactional
    @Override
    public List<Project> getProjectsByMemberId(Long memberId){
        return projectRepository.findAllByMemberId(memberId);
    }

//    @Transactional
//    @Override
//    public Project getByName(String name) {
//        return projectRepository.getByProjectName(name);
//    }
//
//    @Transactional
//    @Override
//    public List<Project> getByState(State state) {
//        return projectRepository.getByState(state);
//    }
//
//    @Transactional
//    @Override
//    public void deleteByName(String name) {
//        if(!projectRepository.existsByProjectName(name)){
//            throw new IllegalStateException("Project(name = " + name + ") no exists.");
//        }
//        projectRepository.deleteByProjectName(name);
//    }
//
//    @Transactional
//    @Override
//    public void updateStateByName(String name, State state) {
//        if(!projectRepository.existsByName(name)){
//            throw new IllegalStateException("Project(name = " + name + ") no exists.");
//        }
//        projectRepository.updateStateByName(name, state);
//    }


}
