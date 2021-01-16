package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.ShelterService;
import com.htne.helpthehomeless.dto.ShelterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/shelter")
public class ShelterController {
    private final ShelterService shelterService;

    @PostMapping(path = "/admin/create")
    public ResponseEntity<ShelterDTO> updateUserLocation(final Authentication auth, @RequestBody final ShelterDTO dto) {
        return new ResponseEntity<>(shelterService.createShelter(dto), HttpStatus.CREATED);
    }
}
