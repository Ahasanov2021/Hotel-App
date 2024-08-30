package com.example.demo.controller;

import com.example.demo.dto.RoomBookingRequest;
import com.example.demo.dto.RoomBookingResponse;
import com.example.demo.service.RoomBookingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableTransactionManagement
public class RoomBookingController {

    @Autowired
    private RoomBookingService roomBookingService;

    @PostMapping("/book")
    public RoomBookingResponse book(RoomBookingRequest request){
        return roomBookingService.book(request);
    }
}
