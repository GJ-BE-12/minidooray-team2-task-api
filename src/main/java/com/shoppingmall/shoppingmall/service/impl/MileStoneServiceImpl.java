package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.exception.AlreadyExistException;
import com.shoppingmall.shoppingmall.repository.MileStoneRepository;
import com.shoppingmall.shoppingmall.service.MileStoneService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MileStoneServiceImpl implements MileStoneService {

    private final MileStoneRepository mileStoneRepository;

    @Override
    public MileStone create(long projectId, MileStone mileStone) {
        if(mileStoneRepository.existsByName(mileStone.getName())){
            throw new AlreadyExistException("이미 존재하는 마일스톤입니다.");
        }
        return mileStoneRepository.save(mileStone);
    }

    @Override
    public List<MileStone> getMileStones(long projectId) {
        return List.of();
    }

    public boolean isProject(long projectId){
        mileStoneRepository.findByProjectId(projectId);
    }
}
