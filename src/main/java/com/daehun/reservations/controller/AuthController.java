package com.daehun.reservations.controller;


import com.daehun.reservations.dto.AuthRequest;
import com.daehun.reservations.dto.AuthResponse;
import com.daehun.reservations.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    private AuthService authService;

    // 회원가입 처리
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody AuthRequest request) {
        authService.register(request);
        return ResponseEntity.ok("회원 등록 성공");
    }

    // 로그인 처리
    @PostMapping("/login")
    public ResponseEntity<AuthResponse> login(@RequestBody AuthRequest request) {
        return ResponseEntity.ok(authService.login(request));
    }
}