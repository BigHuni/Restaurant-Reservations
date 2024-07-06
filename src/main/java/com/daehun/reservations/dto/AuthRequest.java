package com.daehun.reservations.dto;

import lombok.Data;

@Data
public class AuthRequest {
    private String username;    // 사용자명
    private String password;    // 비밀번호
}