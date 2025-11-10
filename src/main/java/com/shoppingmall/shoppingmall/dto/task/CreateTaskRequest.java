package com.shoppingmall.shoppingmall.dto.task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class CreateTaskRequest {
    @NotBlank(message = "제목은 필수입니다.")
    @Size(max = 50, message = "제목은 50자 이내로 작성해야 합니다.")
    private String taskTitle;

    @NotBlank
    @Size(max = 1000, message = "내용은 1000자 이내로 작성해주세요.")
    private String taskContent;

    private Long milestoneIdList; // 마일스톤 한개
    private List<Long> tagIdList; // 여러개의 태그
}
