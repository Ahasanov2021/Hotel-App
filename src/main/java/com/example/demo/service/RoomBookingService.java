package com.example.demo.service;

import com.example.demo.dto.RoomBookingRequest;
import com.example.demo.dto.RoomBookingResponse;
import com.example.demo.model.GuestInfo;
import com.example.demo.model.PaymentInfo;
import com.example.demo.repository.GuestInfoRepository;
import com.example.demo.repository.PaymentInfoRepository;
import com.example.demo.utils.PaymentUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
public class RoomBookingService {

    @Autowired
    private GuestInfoRepository guestInfoRepository;
    @Autowired
    private PaymentInfoRepository paymentInfoRepository;

    @Transactional(readOnly = false, isolation = Isolation.READ_COMMITTED, propagation = Propagation.REQUIRED)
    public RoomBookingResponse book(RoomBookingRequest request){

        GuestInfo guestInfo = request.getGuestInfo();
        guestInfo = guestInfoRepository.save(guestInfo);

        PaymentInfo paymentInfo = request.getPaymentInfo();

        PaymentUtils.validateCreditLimit(paymentInfo.getAccountNo(), guestInfo.getFee());

        paymentInfo.setGuestId(guestInfo.getId());
        paymentInfo.setAmount(guestInfo.getFee());
        paymentInfoRepository.save(paymentInfo);
        return new RoomBookingResponse("SUCCESS", guestInfo.getFee(), UUID.randomUUID().toString().split("-")[0], guestInfo);
    }
}
