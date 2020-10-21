package com.x.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Subfeed;

public interface SubfeedRepository extends JpaRepository<Subfeed, Long> {
    Optional<Subfeed> findByName(String subfeedName);
}