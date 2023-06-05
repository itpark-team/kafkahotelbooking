package com.example.kafkahotelbooking.controllers;

import com.example.kafkahotelbooking.models.Booking;
import com.example.kafkahotelbooking.services.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("booking")
@AllArgsConstructor
public class BookingController {

    private BookingService bookingService;

    @PostMapping("/add-new")
    public String addNew(@RequestBody Booking booking) {

        bookingService.addNew(booking);

        return "ok";
    }
}
