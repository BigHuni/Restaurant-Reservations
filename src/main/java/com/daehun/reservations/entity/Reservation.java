package com.daehun.reservations.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Data
public class Reservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "store_id")
    private Store store;            // 예약된 매장

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;              // 예약한 사용자

    private LocalDateTime reservationTime;      // 예약 시간
    private int numberOfPeople;                 // 예약 인원 수
    private String status;                      // 예약 상태

    public Reservation() {
        this.status = "PENDING"; // 기본 상태를 PENDING으로 설정
    }
}