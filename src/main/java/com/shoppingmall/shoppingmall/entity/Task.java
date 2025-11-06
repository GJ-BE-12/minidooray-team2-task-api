package com.shoppingmall.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private MileStone mileStone;

    @OneToMany(mappedBy = "task")
    private List<Tag> tags = new ArrayList<>();
}
