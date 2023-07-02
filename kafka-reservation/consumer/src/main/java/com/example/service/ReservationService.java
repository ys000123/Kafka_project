package com.example.service;

import com.example.Reservation;
import com.example.domain.ReservationRepository;
import com.example.domain.Reservations;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public void reservation(Reservation reservation) throws InterruptedException {

        try{
            Reservations reservations = new Reservations(null, reservation.getUserId(),reservation.getGameId());
            reservationRepository.save(reservations);
        } catch (Exception e) {

        }
    }
}
