package com.shoppingmall.shoppingmall.dto;

import com.shoppingmall.shoppingmall.entity.State;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProjectRequestDto{
    private String projectName;
    private List<String> tagList;
    private List<String> milestoneList;
}
