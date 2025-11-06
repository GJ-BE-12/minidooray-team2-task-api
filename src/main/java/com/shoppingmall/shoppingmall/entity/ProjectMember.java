package com.shoppingmall.shoppingmall.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Getter
@NoArgsConstructor
@Setter
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne
    @JsonIgnore
    private Project project;

    private long memberId;

    public ProjectMember(long memberId){
        this.memberId = memberId;
    }
}
