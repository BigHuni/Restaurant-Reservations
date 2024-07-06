package com.daehun.reservations.repository;

import com.daehun.reservations.entity.Store;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoreRepository extends JpaRepository<Store, Long> {
}