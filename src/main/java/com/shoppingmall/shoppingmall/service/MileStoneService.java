package com.shoppingmall.shoppingmall.service;

import com.shoppingmall.shoppingmall.entity.MileStone;

import java.util.List;

public interface MileStoneService {
    MileStone create(long projectId, MileStone mileStone);

    List<MileStone> getMileStones(long projectId);
}
