package com.htne.helpthehomeless.dal.dao;

import com.htne.helpthehomeless.dal.model.Pickup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupRepository extends JpaRepository<Pickup, Long> {
}
