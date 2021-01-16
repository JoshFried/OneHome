package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.ReservationService;
import com.htne.helpthehomeless.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/rsvp")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<ReservationDTO> createReservation(final Authentication auth, @RequestParam final Long shelterId) {
        return new ResponseEntity<>(reservationService.createReservation(shelterId), HttpStatus.CREATED);
    }
}
