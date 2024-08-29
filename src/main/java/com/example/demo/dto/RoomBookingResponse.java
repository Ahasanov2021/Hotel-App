package com.example.demo.dto;

import com.example.demo.model.GuestInfo;
import com.example.demo.model.PaymentInfo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoomBookingResponse {
    private String status;
    private double totalFee;
    private String pnrNumber;
    private GuestInfo guestInfo;


}
