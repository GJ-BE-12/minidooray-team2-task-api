package com.shoppingmall.shoppingmall.dto.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CreateProjectRequest {
    private String projectName;
    private List<String> tagList;
    private List<String> mileStoneList;
}
