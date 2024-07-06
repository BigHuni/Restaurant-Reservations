package com.daehun.reservations.service;

import com.daehun.reservations.dto.StoreRequest;
import com.daehun.reservations.entity.Store;
import com.daehun.reservations.repository.StoreRepository;
import com.daehun.reservations.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StoreService {

    @Autowired
    private StoreRepository storeRepository;

    @Autowired
    private UserRepository userRepository;

    // 매장 생성
    public Store createStore(StoreRequest request) {
        Store store = new Store();
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setDescription(request.getDescription());
        // 임시로 owner 설정
        store.setOwner(userRepository.findByUsername("owner").orElseThrow(() -> new RuntimeException("관리자를 찾을 수 없습니다.")));
        return storeRepository.save(store);
    }

    // 특정 매장 정보 조회
    public Store getStore(Long id) {
        return storeRepository.findById(id).orElseThrow(() -> new RuntimeException("매장을 찾을 수 없습니다."));
    }

    // 모든 매장 정보 조회
    public List<Store> getAllStores() {
        return storeRepository.findAll();
    }

    // 매장 정보 수정
    public Store updateStore(Long id, StoreRequest request) {
        Store store = storeRepository.findById(id).orElseThrow(() -> new RuntimeException("매장을 찾을 수 없습니다."));
        store.setName(request.getName());
        store.setLocation(request.getLocation());
        store.setDescription(request.getDescription());
        return storeRepository.save(store);
    }

    // 매장 정보 삭제
    public void deleteStore(Long id) {
        storeRepository.deleteById(id);
    }
}