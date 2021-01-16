package com.htne.helpthehomeless.dal.dao;

import com.htne.helpthehomeless.dal.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
}
