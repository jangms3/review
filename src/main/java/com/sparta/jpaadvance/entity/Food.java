package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "food")
public class Food {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;

    @ManyToOne
//    (fetch = FetchType.LAZY)
    //default 가 eager (즉시)임 -> 연관된 정보를 즉시 가져옴.
    @JoinColumn(name = "user_id")
    private User user; //옆에 체인같이 생긴게 관계가 맺어짐을 의미함.
}