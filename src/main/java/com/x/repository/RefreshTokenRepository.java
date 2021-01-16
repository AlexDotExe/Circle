package com.x.repository;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.RefreshToken;

public interface RefreshTokenRepository extends JpaRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);

    void deleteByToken(String token);
}