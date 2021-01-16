package com.htne.helpthehomeless.dal.service;

import com.google.zxing.WriterException;
import com.htne.helpthehomeless.dal.dao.ReservationRepository;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTHInvalidStateException;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.ReservationDTO;
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

    public ReservationDTO createReservation(final long shelterId) {
        final User       user    = userService.getUserFromContext();
        final ShelterDTO shelter = shelterService.getShelter(shelterId);

        if (shelter.getCapacity() <= shelter.getOccupancy()) {
            throw new HTHInvalidStateException("Selected shelter does not have enough capacity at the moment");
        }
        final Reservation rsvp = Reservation.builder()
                                            .createdAt(Date.from(Instant.now()))
                                            .expiresAt(Date.from(Instant.now().plusSeconds(7200)))
                                            .shelter(mvcConversionService.convert(shelter, Shelter.class))
                                            .user(user)
                                            .build();
        repository.save(rsvp);
        shelterService.incrementOccupancy(shelterId);

        try {
            qrCodeService.generateQRCodeImage(String.valueOf(rsvp.getId()));
        } catch (final WriterException | IOException e) {
            e.printStackTrace();
        }

        return mvcConversionService.convert(rsvp, ReservationDTO.class);
    }

    public ReservationDTO acceptReservation(final long id) {
        final ReservationDTO dto = getReservation(id);

        if (dto.getExpiresAt().before(Date.from(Instant.now()))) {
            throw new HTHInvalidStateException("Reservation has expired");
        }

        dto.setExpiresAt(Date.from(dto.getExpiresAt().toInstant().plusSeconds(86400)));

        return updateReservation(dto);
    }

    private ReservationDTO updateReservation(final ReservationDTO dto) {
        final Reservation rsvp = fetchReservation(dto.getId());
        rsvp.setExpiresAt(dto.getExpiresAt());
        rsvp.setCreatedAt(dto.getCreatedAt());
        return mvcConversionService.convert(repository.save(rsvp), ReservationDTO.class);
    }

    public ReservationDTO getReservation(final long id) {
        return mvcConversionService.convert(fetchReservation(id), ReservationDTO.class);
    }

    private Reservation fetchReservation(final long id) {
        return repository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id))));
    }

}
