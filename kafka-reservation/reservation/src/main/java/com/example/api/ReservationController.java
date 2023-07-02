package com.example.api;

import com.example.service.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping("/reservation")
    private ResponseEntity<Void> addReservation(@RequestBody ReservationRequest request) {
        reservationService.addReservation(request);
        return ResponseEntity.noContent().build();
    }
}
