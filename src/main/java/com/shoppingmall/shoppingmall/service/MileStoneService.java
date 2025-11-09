package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.dto.mileStone.CreateMileStoneRequest;
import com.shoppingmall.shoppingmall.entity.MileStone;

import java.util.List;

public interface MileStoneService {
    MileStone create(long projectId, long memberId, CreateMileStoneRequest createMileStoneRequest);

    List<MileStone> getMileStones(long projectId);

    MileStone update(long projectId, long milestoneId, MileStone updatedMileStone);

    void delete(long projectId, long milestoneId);
}
