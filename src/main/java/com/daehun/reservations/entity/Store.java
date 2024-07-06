package com.daehun.reservations.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Store {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;            // 매장 이름
    private String location;        // 매장 위치
    private String description;     // 매장 설명

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private User owner;             // 매장 관리자
}