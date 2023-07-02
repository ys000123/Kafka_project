package com.example.domain;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FailRepository extends JpaRepository<FailEvents,Long> {
    List<FailEvents> findAllByComplete(boolean complete);
}
