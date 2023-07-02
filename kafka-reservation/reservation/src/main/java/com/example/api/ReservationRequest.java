package com.example.api;

import lombok.Data;

@Data
public class ReservationRequest {

    private Long userId;
    private Long gameId;
}
