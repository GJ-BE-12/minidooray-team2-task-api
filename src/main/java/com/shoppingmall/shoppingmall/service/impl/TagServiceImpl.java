package com.shoppingmall.shoppingmall.service.impl;

import com.shoppingmall.shoppingmall.entity.MileStone;
import com.shoppingmall.shoppingmall.entity.Project;
import com.shoppingmall.shoppingmall.entity.Tag;
import com.shoppingmall.shoppingmall.exception.AlreadyExistException;
import com.shoppingmall.shoppingmall.exception.NotFoundException;
import com.shoppingmall.shoppingmall.repository.ProjectRepository;
import com.shoppingmall.shoppingmall.repository.TagRepository;
import com.shoppingmall.shoppingmall.service.TagService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;
    private final ProjectRepository projectRepository;

    @Override
    public Tag create(Long projectId, Tag tag) {

        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new NotFoundException("Project not found with id: " + projectId));

        if (tagRepository.existsByName(tag.getName())) {
            throw new AlreadyExistException(tag.getName() + " 이름의 태그가 이미 존재합니다");
        }

        tag.setProject(project);

        return tagRepository.save(tag);
    }

    @Override
    public List<Tag> getTags(Long projectId) {
        return tagRepository.findByProjectId(projectId);
    }

    @Override
    public Tag update(Long projectId, Long tagId, Tag updatedTag) {
        Tag tag = tagRepository.findById(tagId).orElseThrow(() -> new NotFoundException("해당하는 Tag가 없습니다 : " + tagId));
        tag.setName(updatedTag.getName());

        return tagRepository.save(tag);
    }

    @Override
    public void delete(Long projectId, Long tagId) {
        if(!tagRepository.existsById(tagId)){
            throw new NotFoundException("해당하는 tag가 없습니다 : " + tagId);
        }
        tagRepository.deleteById(tagId);
    }


}
