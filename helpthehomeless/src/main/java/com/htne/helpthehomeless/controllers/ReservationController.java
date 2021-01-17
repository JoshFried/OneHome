package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.ReservationService;
import com.htne.helpthehomeless.dto.ReservationDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/rsvp")
public class ReservationController {
    private final ReservationService reservationService;

    @PostMapping(path = "/{shelterId}")
    public ResponseEntity<ReservationDTO> createReservation(final Authentication auth, @PathVariable final Long shelterId) {
        return new ResponseEntity<>(reservationService.createReservation(shelterId), HttpStatus.CREATED);
    }

    @GetMapping(path = "/{reservationId}")
    public ResponseEntity<ReservationDTO> acceptReservation(final Authentication auth, @PathVariable final long reservationId) {
        return new ResponseEntity<>(reservationService.acceptReservation(reservationId), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/{reservationId}")
    public ResponseEntity deleteReservation(final Authentication auth, @PathVariable final long reservationId) {
        reservationService.deleteReservation(reservationId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping(path = "/user/{userId}")
    public ResponseEntity<ReservationDTO> findUserReservation(final Authentication auth, @PathVariable final long userId) {
        
        return new ResponseEntity<>(reservationService.getUserReservation(userId), HttpStatus.ACCEPTED);
    }
}
