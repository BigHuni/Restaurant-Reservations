package com.daehun.reservations.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;    // 사용자명
    private String password;    // 비밀번호

    @Enumerated(EnumType.STRING)
    private Role role;          // 역할
}