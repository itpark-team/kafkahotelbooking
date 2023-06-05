package com.example.kafkahotelbooking.services;

import com.example.kafkahotelbooking.models.Booking;
import com.google.gson.Gson;
import lombok.AllArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class BookingService {

    private Gson gson;
    private KafkaTemplate<String, String> kafkaTemplate;

    public int getRandomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public void addNew(Booking booking) {
        booking.setId(getRandomNumber(1, 1000000));

        String bookingAsJson = gson.toJson(booking);

        kafkaTemplate.send("gaytgqueue", bookingAsJson);
    }
}
