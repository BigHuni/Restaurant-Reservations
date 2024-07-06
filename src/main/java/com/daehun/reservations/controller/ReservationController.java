package com.daehun.reservations.controller;

import com.daehun.reservations.dto.ReservationRequest;
import com.daehun.reservations.entity.Reservation;
import com.daehun.reservations.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    // 예약 생성
    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestBody ReservationRequest request) {
        return ResponseEntity.ok(reservationService.createReservation(request));
    }

    // 특정 예약 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<Reservation> getReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.getReservation(id));
    }

    // 모든 예약 정보 조회
    @GetMapping
    public ResponseEntity<List<Reservation>> getAllReservations() {
        return ResponseEntity.ok(reservationService.getAllReservations());
    }

    // 예약 확인
    @PutMapping("/confirm/{id}")
    public ResponseEntity<Reservation> confirmReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.confirmReservation(id));
    }

    // 예약 승인
    @PutMapping("/approve/{id}")
    public ResponseEntity<Reservation> approveReservation(@PathVariable Long id) {
        return ResponseEntity.ok(reservationService.approveReservation(id));
    }

    // 예약 거절
    @PutMapping("/reject/{id}")
    public ResponseEntity<Void> rejectReservation(@PathVariable Long id) {
        reservationService.rejectReservation(id);
        return ResponseEntity.ok().build();
    }
}