package com.daehun.reservations.controller;

import com.daehun.reservations.dto.StoreRequest;
import com.daehun.reservations.entity.Store;
import com.daehun.reservations.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/stores")
public class StoreController {

    @Autowired
    private StoreService storeService;

    // 매장 생성
    @PostMapping
    public ResponseEntity<Store> createStore(@RequestBody StoreRequest request) {
        return ResponseEntity.ok(storeService.createStore(request));
    }

    // 특정 매장 정보 조회
    @GetMapping("/{id}")
    public ResponseEntity<Store> getStore(@PathVariable Long id) {
        return ResponseEntity.ok(storeService.getStore(id));
    }

    // 모든 매장 정보 조회
    @GetMapping
    public ResponseEntity<List<Store>> getAllStores() {
        return ResponseEntity.ok(storeService.getAllStores());
    }

    // 매장 정보 수정
    @PutMapping("/{id}")
    public ResponseEntity<Store> updateStore(@PathVariable Long id, @RequestBody StoreRequest request) {
        return ResponseEntity.ok(storeService.updateStore(id, request));
    }

    // 매장 정보 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteStore(@PathVariable Long id) {
        storeService.deleteStore(id);
        return ResponseEntity.ok().build();
    }
}