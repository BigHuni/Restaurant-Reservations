package com.daehun.reservations.repository;

import com.daehun.reservations.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

// 사용자명을 통해 사용자 조회
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}