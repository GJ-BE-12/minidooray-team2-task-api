package com.shoppingmall.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class MileStone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    @ManyToOne
    private Project project;

    @OneToMany
    private List<Task> tasks = new ArrayList<>();

    public MileStone(String name){
        this.name = name;
    }
}
