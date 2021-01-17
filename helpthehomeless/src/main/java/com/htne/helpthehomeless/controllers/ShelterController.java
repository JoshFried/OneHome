package com.htne.helpthehomeless.controllers;

import com.htne.helpthehomeless.dal.service.ShelterService;
import com.htne.helpthehomeless.dto.ShelterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/shelter")
public class ShelterController {
    private final ShelterService shelterService;

    @PostMapping(path = "/admin/create")
    public ResponseEntity<ShelterDTO> createShelter(final Authentication auth, @RequestBody final ShelterDTO dto) {
        return new ResponseEntity<>(shelterService.createShelter(dto), HttpStatus.CREATED);
    }

    @PutMapping(path = "/wait")
    public ResponseEntity<ShelterDTO> addToWaitingList(final Authentication auth, @RequestParam final Long shelterId) {
        return new ResponseEntity<>(shelterService.addToWaitingList(shelterId), HttpStatus.ACCEPTED);
    }

    @PutMapping("/admin/update")
    public ResponseEntity<ShelterDTO> updateShelter(final Authentication auth, @RequestBody final ShelterDTO dto) {
        return new ResponseEntity<>(shelterService.updateShelter(dto), HttpStatus.ACCEPTED);
    }

}
