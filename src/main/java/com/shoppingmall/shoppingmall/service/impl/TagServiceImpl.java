package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.dto.tag.CreateTagRequest;
import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.exception.already.AlreadyExistException;
import com.shoppingmall.shoppingmall.exception.already.TagAlreadyExistException;
import com.shoppingmall.shoppingmall.exception.notfound.NotFoundException;
import com.shoppingmall.shoppingmall.exception.notfound.ProjectNotFoundException;
import com.shoppingmall.shoppingmall.exception.notfound.TagNotFoundException;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import com.shoppingmall.shoppingmall.repository.TagRepository;
import com.shoppingmall.shoppingmall.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {
    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;

    @Override
    public Tag create(Long projectId, CreateTagRequest createTagRequest) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));

        if(tagRepository.existsByName(createTagRequest.getName())){
            throw new TagAlreadyExistException(createTagRequest.getName());
        }

        Tag tag = new Tag(createTagRequest.getName());
        tag.setProject(project);

        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getTags(Long projectId) {
        projectRepository.findById(projectId)
                .orElseThrow(() -> new ProjectNotFoundException(projectId));
        return tagRepository.findAllByProjectId(projectId);
    }

    @Override
    public Tag updateTag(Long projectId, Long tagId, Tag updatedTag) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new TagNotFoundException(tagId));
        tag.setName(updatedTag.getName());

        return tagRepository.save(tag);
    }

    @Override
    public void deleteTag(Long projectId, Long tagId) {
        Tag tag = tagRepository.findByIdAndProjectId(tagId, projectId);
        tagRepository.delete(tag);
    }
}
