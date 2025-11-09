package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.ProjectMember;
import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.exception.AlreadyExistException;
import com.shoppingmall.shoppingmall.exception.NotFoundException;
import com.shoppingmall.shoppingmall.repository.ProjectMemberRepository;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import com.shoppingmall.shoppingmall.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final ProjectMemberRepository projectMemberRepository;

    // memberId 해당하는 member가 프로젝트 생성
    @Transactional
    @Override
    public Project create(String name, Long memberId, List<String> tagNames, List<String> mileStoneNames) {

        // 이미 존재하는 Project 이름 예외 처리
        if(projectRepository.existsByProjectName(name)){
            throw new AlreadyExistException("Project(name = " + name + ") already exists.");
        }

        // 프로젝트 객체 생성 state는 default, adminId는 memberId (비영속)
        Project project = new Project(name, memberId);

        // ProjectMember 객체에 memberId를 생성자를 통해 주입후 생성 (비영속)
        ProjectMember adminMember = new ProjectMember(memberId);

        // Project 객체의 projectMembers 리스트에 adminMember 객체를 추가
        project.addProjectMember(adminMember);


        if (tagNames != null && !tagNames.isEmpty()) {
            List<Tag> tagList = new ArrayList<>();
            for(String tagName : tagNames){
                Tag tag = new Tag();
                tag.setName(tagName);
                tag.setProject(project);
                tagList.add(tag);
            }
            project.setTags(tagList);
        }

        if(mileStoneNames != null && !mileStoneNames.isEmpty()){
            List<MileStone> mileStoneList = new ArrayList<>();
            for(String mileStoneName : mileStoneNames){
                MileStone mileStone = new MileStone();
                mileStone.setName(mileStoneName);
                mileStone.setProject(project);
                mileStoneList.add(mileStone);
            }
            project.setMileStones(mileStoneList);
        }


        // 여기서 영속성 전이 발생

        return projectRepository.save(project);
    }

    // 해당 멤버가 들어가 있는 Project 목록을 조회
    @Transactional
    @Override
    public List<Project> getProjectsByMemberId(Long memberId){
        return projectRepository.findProjectsByMemberId(memberId);
    }

    // 프로젝트에 멤버 등록
    @Transactional
    @Override
    public ProjectMember addMemberToProject(Long projectId, Long memberId) {

        // 멤버에 맞는 프로젝트가 없을시 예외
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project not found id: " + projectId));



        // 해당 프로젝트에 멤버가 이미 존재할시 예외
        if(projectMemberRepository.existsByProjectIdAndMemberId(projectId, memberId)){
            throw new AlreadyExistException("Member ID already exists in the project");
        }



        ProjectMember newMember = new ProjectMember(memberId);
        project.addProjectMember(newMember);

        return projectMemberRepository.save(newMember);
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
