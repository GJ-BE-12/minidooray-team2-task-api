package com.shoppingmall.shoppingmall.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class CreateTaskRequest {
    private String title;
    private String content;
}
