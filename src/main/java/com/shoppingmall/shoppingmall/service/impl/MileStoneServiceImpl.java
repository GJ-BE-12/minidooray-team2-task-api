package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.exception.NotFoundException;
import com.shoppingmall.shoppingmall.exception.AlreadyExistException;
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
    public MileStone create(long projectId, long memberId, MileStone mileStone) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + projectId));

        // 마일스톤의 이름이 존재할시 예외처리
        if(mileStoneRepository.existsByProjectAndName(project, mileStone.getName())){
            throw new AlreadyExistException("이미 존재하는 마일스톤입니다.");
        }

        mileStone.setProject(project);

        return mileStoneRepository.save(mileStone);
    }

    @Transactional
    @Override
    public List<MileStone> getMileStones(long projectId) {
        return mileStoneRepository.findByProjectId(projectId);
    }

    @Transactional
    @Override
    public MileStone update(long projectId, long milestoneId, MileStone updatedMileStone) {
        MileStone mileStone = mileStoneRepository.findById(milestoneId).orElseThrow(() -> new NotFoundException("해당하는 mileStone이 없습니다 : " + milestoneId));
        mileStone.setName(updatedMileStone.getName());

        return mileStoneRepository.save(mileStone);
    }

    @Transactional
    @Override
    public void delete(long projectId, long milestoneId) {
        if(!mileStoneRepository.existsById(milestoneId)){
            throw new NotFoundException("해당하는 mileStone이 없습니다 : " + milestoneId);
        }
        mileStoneRepository.deleteById(milestoneId);
    }
}
