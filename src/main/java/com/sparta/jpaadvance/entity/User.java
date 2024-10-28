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



    @OneToMany(mappedBy = "user",cascade = CascadeType.PERSIST, orphanRemoval = true)
    // food 까지 한번에 저장되길 원해 cascade type 중 persist 사용
    // delete 는 remove 지원

    //jpa 상에서 orphan  removal =true 를 지원함으로 써
    // 연관관계 뿐만 아니라 db에서도 데이터 처리가 가능해짐
    private List<Food> foodList =new ArrayList<>();

    public void addFoodList(Food food) {
        this.foodList.add(food);
        food.setUser(this); // 외래 키 설정
    }
}