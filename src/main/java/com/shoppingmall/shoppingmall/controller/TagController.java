package com.shoppingmall.shoppingmall.controller;

import com.shoppingmall.shoppingmall.dto.CreateTagRequest;
import com.shoppingmall.shoppingmall.dto.TagResponse;
import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.service.TagService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/projects")
public class TagController {
    private final TagService tagService;

    @PostMapping("/{projectId}/tags")
    public ResponseEntity<Long> create(@PathVariable("projectId") Long projectId,
                                              @Valid @RequestBody CreateTagRequest createTagRequest){
        tagService.create(projectId, createTagRequest);
        return ResponseEntity.ok().body(projectId);
    }

    @GetMapping("/{projectId}/tags")
    public ResponseEntity<List<TagResponse>> getTags(@PathVariable("projectId") Long projectId) {
        List<TagResponse> responses = tagService.getTags(projectId)
                .stream()
                .map(TagResponse::from)
                .toList();
        return ResponseEntity.ok(responses);
    }

    @PutMapping("/{projectId}/tags/{tagId}")
    public Tag update(@PathVariable long projectId,
                      @PathVariable long tagId,
                      @RequestBody Tag updatedTag) {
        return tagService.update(projectId, tagId, updatedTag);
    }

    @DeleteMapping("/{projectId}/tags/{tagId}")
    public ResponseEntity<Void> delete(@PathVariable("projectId") Long projectId,
                                       @PathVariable("tagId") Long tagId){
        tagService.deleteTag(projectId, tagId);
        return ResponseEntity.noContent().build();
    }
}
