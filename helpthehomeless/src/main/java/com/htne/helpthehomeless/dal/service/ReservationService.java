package com.htne.helpthehomeless.dal.service;

import com.google.zxing.WriterException;
import com.htne.helpthehomeless.dal.dao.mapper.ReservationRepository;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.HTHInvalidStateException;
import com.htne.helpthehomeless.dto.ReservationDTO;
import com.htne.helpthehomeless.dto.ReservationRequestDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.Date;
import java.time.Instant;

@Service
@RequiredArgsConstructor
public class ReservationService {
    private final ReservationRepository repository;
    private final UserService           userService;
    private final QRCodeService         qrCodeService;
    private final ShelterService        shelterService;
    private final ConversionService     mvcConversionService;

    public ReservationDTO createReservation(final ReservationRequestDTO request) {
        final User       user    = userService.getUserFromContext();
        final ShelterDTO shelter = shelterService.getShelter(request.getShelterId());

        if (shelter.getCapacity() <= shelter.getOccupancy()) {
            throw new HTHInvalidStateException("Selected shelter does not have enough capacity at the moment");
        }

        final Reservation rsvp = Reservation.builder()
                                            .createdAt(Date.from(Instant.now()))
                                            .expiresAt(Date.from(Instant.now().plusSeconds(7200)))
                                            .shelter(mvcConversionService.convert(shelter, Shelter.class))
                                            .user(user)
                                            .build();

        try {
            qrCodeService.getQRCodeImage(String.valueOf(rsvp.getId()));
        } catch (final WriterException e) {
            e.printStackTrace();
        } catch (final IOException e) {
            e.printStackTrace();
        }

        return mvcConversionService.convert(repository.save(rsvp), ReservationDTO.class);
    }
}
