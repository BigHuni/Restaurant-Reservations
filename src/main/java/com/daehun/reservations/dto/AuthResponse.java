package com.daehun.reservations.dto;

import lombok.Data;

@Data
public class AuthResponse {
    private String token;   // JWT 토큰

    public AuthResponse(String token) {
        this.token = token;
    }
}
