package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/projects")
public class TagController {

    private final TagService tagService;

    // tag를 추가하는 컨트롤러
    @PostMapping("/{projectId}/tags")
    public Tag create(@PathVariable long projectId,
                            @RequestBody Tag tag,
                            @RequestHeader("memberId") Long memberId){
        return tagService.create(projectId, tag);
    }

    // 해당 프로젝트의 tag 목록을 보여주는 컨트롤러
    @GetMapping("/{projectId}/tags")
    public List<Tag> getTags(@PathVariable long projectId){
        return tagService.getTags(projectId);
    }

    @PutMapping("/{projectId}/tags/{tagId}")
    public Tag update(@PathVariable long projectId,
                            @PathVariable long tagId,
                            @RequestBody Tag updatedTag) {
        return tagService.update(projectId, tagId, updatedTag);
    }

    @DeleteMapping("/{projectId}/tags/{tagId}")
    public void delete(@PathVariable long projectId,
                       @PathVariable long tagId) {
        tagService.delete(projectId, tagId);
    }
}
