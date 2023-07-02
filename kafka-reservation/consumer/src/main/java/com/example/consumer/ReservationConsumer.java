package com.example.consumer;

import com.example.Reservation;
import com.example.domain.FailEvents;
import com.example.domain.FailRepository;
import com.example.service.ReservationService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ReservationConsumer {

    private final ObjectMapper objectMapper;
    private final ReservationService reservationService;
    private final FailRepository failRepository;

    @KafkaListener(topics = {"add_reservation"}, groupId = "payment")
    public void consume(String jsonObject) {
        try {
            var reservation = objectMapper.readValue(jsonObject, Reservation.class);
            reservationService.reservation(reservation);
        } catch (Exception e){
            failRepository.save(FailEvents.of(jsonObject));
        }
    }
}
