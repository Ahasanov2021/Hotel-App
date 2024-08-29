package com.example.demo.repository;

import com.example.demo.model.GuestInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GuestInfoRepository extends JpaRepository<GuestInfo, Long> {
}
