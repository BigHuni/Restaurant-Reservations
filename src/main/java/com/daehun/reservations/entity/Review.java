package com.daehun.reservations.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 리뷰 작성된 예약
    @ManyToOne
    @JoinColumn(name = "reservation_id")
    private Reservation reservation;

    // 리뷰 내용
    private String content;

    // 리뷰 작성자
    @ManyToOne
    @JoinColumn(name = "author_id")
    private User author;
}