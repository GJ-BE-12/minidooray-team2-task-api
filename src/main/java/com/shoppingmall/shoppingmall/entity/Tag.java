package com.shoppingmall.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

// Tag가 뭔지 정확히 확인

@Entity
@Getter
@Setter
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    @JsonIgnore
    private Project project;

    @OneToMany(mappedBy = "tag")
    private List<TaskTag> taskTags = new ArrayList<>();

}
