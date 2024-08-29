package com.example.demo.repository;

import com.example.demo.model.GuestInfo;
import com.example.demo.model.PaymentInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentInfoRepository extends JpaRepository<PaymentInfo, String> {

}
