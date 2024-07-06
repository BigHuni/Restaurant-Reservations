package com.daehun.reservations.dto;

import lombok.Data;

@Data
public class StoreRequest {
    private String name;            // 매장 이름
    private String location;        // 매장 위치
    private String description;     // 매장 설명
}