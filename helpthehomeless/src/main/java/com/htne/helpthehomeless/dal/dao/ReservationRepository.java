package com.htne.helpthehomeless.dal.dao;

import com.htne.helpthehomeless.dal.model.Reservation;
import org.springframework.data.repository.CrudRepository;

public interface ReservationRepository extends CrudRepository<Reservation, Long> {
}
