package com.daehun.reservations.dto;

import lombok.Data;

@Data
public class ReservationRequest {
    private Long storeId;               // 매장 ID
    private String reservationTime;     // 예약 시간
    private int numberOfPeople;         // 인원 수
    private String username;            // 사용자명
}