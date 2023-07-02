package com.example.service;

import com.example.Reservation;
import com.example.api.ReservationRequest;
import com.example.producer.CreatedReservationProducer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final CreatedReservationProducer createdReservationProducer;

    public void addReservation(ReservationRequest request) {
        Reservation reservation = new Reservation(request.getUserId(), request.getGameId());
        // 카프카 전송
        createdReservationProducer.createdReservation(reservation);
    }


}
