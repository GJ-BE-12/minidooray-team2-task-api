package com.shoppingmall.shoppingmall.entity;

import jakarta.persistence.*;

// Tag가 뭔지 정확히 확인

@Entity
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String category;

    @ManyToOne
    private Task task;

}
