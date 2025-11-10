package com.shoppingmall.shoppingmall.dto.mileStone;

import com.shoppingmall.shoppingmall.entity.MileStone;

public record GetMileStoneResponse(Long id, String milestoneName){
    public static GetMileStoneResponse from (MileStone milestone){
        return new GetMileStoneResponse(milestone.getId(), milestone.getName());
    }
}