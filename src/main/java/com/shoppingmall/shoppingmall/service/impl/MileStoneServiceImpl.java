package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.dto.mileStone.MileStoneRequest;
import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.exception.already.MileStoneAlreadyExistException;
import com.shoppingmall.shoppingmall.exception.notfound.MileStoneNotFoundException;
import com.shoppingmall.shoppingmall.exception.notfound.NotFoundException;
import com.shoppingmall.shoppingmall.repository.MileStoneRepository;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import com.shoppingmall.shoppingmall.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MileStoneRepository mileStoneRepository;
    private final ProjectRepository projectRepository;

    // 마일스톤을 생성함
    @Override
    public MileStone create(long projectId, long memberId, MileStoneRequest createMileStoneRequest) {

        Project project = projectRepository.findById(projectId);

        // 마일스톤의 이름이 존재할시 예외처리
        if(mileStoneRepository.existsByProjectAndName(project, createMileStoneRequest.getMilestoneName())){
            throw new MileStoneAlreadyExistException(createMileStoneRequest.getMilestoneName());
        }

        MileStone mileStone = new MileStone(createMileStoneRequest.getMilestoneName());
        mileStone.setProject(project);

        return mileStoneRepository.save(mileStone);
    }

    @Override
    public List<MileStone> getMileStones(long projectId) {
        return mileStoneRepository.findByProjectId(projectId);
    }

    @Transactional
    @Override
    public void update(long projectId, long milestoneId, MileStoneRequest updatedMileStone) {
        MileStone mileStone = mileStoneRepository.findByIdAndProjectId(milestoneId, projectId);
        if(mileStone == null){
            throw new MileStoneNotFoundException(milestoneId);
        }
        mileStone.setName(updatedMileStone.getMilestoneName());
    }

    @Transactional
    @Override
    public void delete(long projectId, long milestoneId) {
        if(mileStoneRepository.existsByIdAndProjectId(milestoneId, projectId)){
            throw new MileStoneNotFoundException(milestoneId);
        }
        mileStoneRepository.deleteById(milestoneId);
    }
}
