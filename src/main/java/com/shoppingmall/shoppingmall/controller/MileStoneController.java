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

    // mileStone을 추가하는 컨트롤러
    @PostMapping("/{projectId}/milestones")
    public MileStone create(@PathVariable long projectId,
                            @RequestBody MileStone mileStone,
                            @RequestHeader("memberId") Long memberId){
        return mileStoneService.create(projectId, memberId, mileStone);
    }

    // 해당 프로젝트의 mileStone 목록을 보여주는 컨트롤러
    @GetMapping("/{projectId}/milestones")
    public List<MileStone> getMileStones(@PathVariable long projectId){
        return mileStoneService.getMileStones(projectId);
    }

    @PutMapping("/{projectId}/milestones/{milestoneId}")
    public MileStone update(@PathVariable long projectId,
                            @PathVariable long milestoneId,
                            @RequestBody MileStone updatedMileStone) {
        return mileStoneService.update(projectId, milestoneId, updatedMileStone);
    }

    @DeleteMapping("/{projectId}/milestones/{milestoneId}")
    public void delete(@PathVariable long projectId,
                       @PathVariable long milestoneId) {
        mileStoneService.delete(projectId, milestoneId);
    }
}
