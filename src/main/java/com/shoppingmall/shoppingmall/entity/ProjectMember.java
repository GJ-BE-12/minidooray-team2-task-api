package com.shoppingmall.shoppingmall.entity;

import jakarta.persistence.*;
import lombok.Getter;


@Entity
@Getter
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    private Project project;

    // 연결을 어떻게 할지?
    private long memberId;
}
