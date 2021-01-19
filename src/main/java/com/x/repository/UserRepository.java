package com.x.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.x.model.Userr;

public interface UserRepository extends JpaRepository<Userr, Long> {
    Optional<Userr> findByUsername(String username);
    Optional<Userr> findByEmail(String email);
}