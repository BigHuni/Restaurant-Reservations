package com.daehun.reservations.service;

import com.daehun.reservations.dto.ReservationRequest;
import com.daehun.reservations.entity.Reservation;
import com.daehun.reservations.entity.Store;
import com.daehun.reservations.entity.User;
import com.daehun.reservations.repository.ReservationRepository;
import com.daehun.reservations.repository.StoreRepository;
import com.daehun.reservations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    // 예약 생성
    public Reservation createReservation(ReservationRequest request) {
        Optional<Store> storeOpt = storeRepository.findById(request.getStoreId());
        Optional<User> userOpt = userRepository.findByUsername(request.getUsername());

        if (storeOpt.isPresent() && userOpt.isPresent()) {
            Reservation reservation = new Reservation();
            reservation.setStore(storeOpt.get());
            reservation.setUser(userOpt.get());
            reservation.setReservationTime(LocalDateTime.parse(request.getReservationTime()));
            reservation.setNumberOfPeople(request.getNumberOfPeople());
            reservation.setStatus("PENDING");
            return reservationRepository.save(reservation);
        }
        throw new RuntimeException("매장 혹은 사용자를 찾을 수 없습니다.");
    }

    // 특정 예약 정보 조회
    public Reservation getReservation(Long id) {
        return reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));
    }

    // 모든 예약 정보 조회
    public List<Reservation> getAllReservations() {
        return reservationRepository.findAll();
    }

    // 예약 확인
    public Reservation confirmReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));
        reservation.setStatus("CONFIRMED");
        return reservationRepository.save(reservation);
    }

    // 예약 승인
    public Reservation approveReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));
        reservation.setStatus("APPROVED");
        return reservationRepository.save(reservation);
    }

    // 예약 거절
    public void rejectReservation(Long id) {
        Reservation reservation = reservationRepository.findById(id).orElseThrow(() -> new RuntimeException("예약을 찾을 수 없습니다."));
        reservation.setStatus("REJECTED");
        reservationRepository.save(reservation);
    }
}