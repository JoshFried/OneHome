package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.model.Pickup;
import com.htne.helpthehomeless.dal.service.PickupService;
import com.htne.helpthehomeless.dto.PickupDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequiredArgsConstructor
public class PickupController {
    private PickupService pickupService;

    @PostMapping("/createPickup")
    public ResponseEntity<PickupDTO> createPickup
            (final Authentication auth, @RequestParam final Date appointmentDate, @RequestParam final Long reservationId,
             @RequestParam final int distance){
        return new ResponseEntity<>(pickupService.createPickup(distance,reservationId,appointmentDate), HttpStatus.CREATED);
    }

    @DeleteMapping("/deletePickup")
    public ResponseEntity<Boolean> createPickup
            (final Authentication auth, @RequestParam final Long id){
        return new ResponseEntity<>(pickupService.deletePickup(id), HttpStatus.GONE);
    }

}
