package com.htne.helpthehomeless.dal.dao;

import com.htne.helpthehomeless.dal.model.Shelter;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ShelterRepository extends JpaRepository<Shelter, Long> {
    Optional<Shelter> findByName(String name);
}
