package com.shoppingmall.shoppingmall.dto.mileStone;

import com.shoppingmall.shoppingmall.entity.MileStone;

public record GetMileStoneResponse(Long id, String name){
    public static GetMileStoneResponse from (MileStone mileStone){
        return new GetMileStoneResponse(mileStone.getId(), mileStone.getName());
    }
}