package com.htne.helpthehomeless.controllers;

import com.google.maps.errors.ApiException;
import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dal.service.ShelterService;
import com.htne.helpthehomeless.dto.LocationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/shelter")
public class ShelterController {
    private final ShelterService shelterService;

    @PostMapping(path = "/admin/create")
    public ResponseEntity<ShelterDTO> updateUserLocation(final Authentication auth, @RequestBody final ShelterDTO dto) {
        return new ResponseEntity<>(shelterService.createShelter(dto), HttpStatus.CREATED);
    }

    @GetMapping(path = "/getShelters")
    public ResponseEntity<String> updateUserLocation
            (@RequestParam final int radius, @RequestParam final double longitude, @RequestParam final double latitude)
            throws InterruptedException, ApiException, IOException {
        return new ResponseEntity<>
                (shelterService.getRegisteredShelters(longitude, latitude, radius), HttpStatus.CREATED);
    }



}
