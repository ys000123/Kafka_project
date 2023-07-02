package com.example.producer;

import com.example.Reservation;
import com.example.domain.FailEvents;
import com.example.domain.FailRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CreatedReservationProducer {

    private final KafkaTemplate<String, String> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final FailRepository failRepository;

    public void createdReservation(Reservation article) {
        String jsonObject=null;
        try {
            jsonObject= objectMapper.writeValueAsString(article);      //json 변환
            kafkaTemplate.send("add_reservation", jsonObject);  // Kafka 에 전송
        } catch (Exception e) {
            // 카프카 전송 실패 로직
            failRepository.save(FailEvents.of(jsonObject));
        }
    }


}
