package com.example.demo.dto;

import com.example.demo.model.GuestInfo;
import com.example.demo.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingRequest {
    private GuestInfo guestInfo;
    private PaymentInfo paymentInfo;
}
