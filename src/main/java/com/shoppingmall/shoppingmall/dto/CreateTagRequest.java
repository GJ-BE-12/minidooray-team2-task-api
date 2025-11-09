package com.shoppingmall.shoppingmall.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CreateTagRequest {
    @NotBlank(message = "태그명은 필수입니다.")
    @Size(max = 20, message = "태그명은 20자 이내로 작성해야 합니다.")
    private String name;
}
