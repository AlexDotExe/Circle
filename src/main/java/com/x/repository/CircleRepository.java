package com.x.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Circle;

public interface CircleRepository extends JpaRepository<Circle, Long> {
    Optional<Circle> findByName(String subfeedName);
}