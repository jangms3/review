package com.sparta.jpaadvance.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;



    @OneToMany(mappedBy = "user",cascade = CascadeType.REMOVE)
    // food 까지 한번에 저장되길 원해 cascade type 중 persist 사용
    // delete 는 remove 지원
    private List<Food> foodList =new ArrayList<>();

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this); // 외래 키 설정
    }
}