package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.repository.MileStoneRepository;
import com.shoppingmall.shoppingmall.service.MileStoneService;
import lombok.Setter;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/projects")
@Setter
public class MileStoneController {

    private MileStoneService mileStoneService;

    @PostMapping("/{projectId}/milestones")
    public MileStone create(@PathVariable long projectId,
                            @RequestBody MileStone mileStone){
        return mileStoneService.create(projectId, mileStone);
    }

    @GetMapping("/{projectId}/milestones")
    public List<MileStone> getMileStones(@PathVariable long projectId){
        return mileStoneService.getMileStones(projectId);
    }
}
