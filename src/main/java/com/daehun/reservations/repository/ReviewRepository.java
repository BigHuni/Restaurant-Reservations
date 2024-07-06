package com.daehun.reservations.repository;

import com.daehun.reservations.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Long> {
}