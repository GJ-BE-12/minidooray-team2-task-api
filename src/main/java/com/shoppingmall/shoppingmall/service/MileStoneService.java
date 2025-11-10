package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.dto.mileStone.MileStoneRequest;
import com.shoppingmall.shoppingmall.entity.MileStone;

import java.util.List;

public interface MileStoneService {
    MileStone create(long projectId, long memberId, MileStoneRequest createMileStoneRequest);

    List<MileStone> getMileStones(long projectId);

    void update(long projectId, long milestoneId, MileStoneRequest updatedMileStone);

    void delete(long projectId, long milestoneId);
}
