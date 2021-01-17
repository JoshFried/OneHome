package com.htne.helpthehomeless.dal.dao;

import com.htne.helpthehomeless.dal.model.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    Optional<Reservation> findByUserId(long userId);
}
