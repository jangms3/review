package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "orders")
public class Order { //중계테이블 형성 .. 외래키의 주인이 됨.
    // 양쪽 다 컨트롤하기 위해서 다대일 을 둘다 걸어둠.

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne //one to many 인 food 에서 -> many to one 으로 받는 거.
    @JoinColumn(name = "food_id") //fk
    private Food food;

    @ManyToOne //one to many 인 User 에서 -> many to one 으로 받는 거.
    @JoinColumn(name = "user_id") //fk
    private User user;
}