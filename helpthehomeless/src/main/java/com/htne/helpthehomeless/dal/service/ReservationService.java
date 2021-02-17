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
import com.htne.helpthehomeless.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.validation.constraints.NotNull;
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
    private final EmailService          emailService;
    private final String                URL = "http://localhost:8080/";

    public ReservationDTO createReservation(final long shelterId) {
        final User       user    = userService.getUserFromContext();
        final ShelterDTO shelter = shelterService.getShelter(shelterId);

        shelterService.recieveVisitor(shelterId, mvcConversionService.convert(user, UserDTO.class));
        final Reservation rsvp = buildReservation(user, shelter);
        repository.save(rsvp);

        try {
            emailService.emailQRCode(user.getEmail(), qrCodeService.generateQRCodeImage(URL + rsvp.getId()));
        } catch (final WriterException | IOException | MessagingException e) {
            e.printStackTrace();
        }
        return mvcConversionService.convert(rsvp, ReservationDTO.class);
    }

    public ReservationDTO acceptReservation(final long id) {
        final ReservationDTO dto = getReservation(id);

        if (dto.getExpiresAt().before(Date.from(Instant.now()))) {
            throw new HTHInvalidStateException("Reservation has expired");
        }

        shelterService.checkin(dto);
        dto.setExpiresAt(Date.from(dto.getExpiresAt().toInstant().plusSeconds(86400)));
        return updateReservation(dto);
    }

    private ReservationDTO updateReservation(@NotNull final ReservationDTO dto) {
        final Reservation rsvp = fetchReservation(dto.getId());
        rsvp.setExpiresAt(dto.getExpiresAt());
        rsvp.setCreatedAt(dto.getCreatedAt());
        return mvcConversionService.convert(repository.save(rsvp), ReservationDTO.class);
    }

    public ReservationDTO getReservation(final long id) {
        return mvcConversionService.convert(fetchReservation(id), ReservationDTO.class);
    }

    public void deleteReservation(final long id) {
        final Reservation rsvp = fetchReservation(id);
        shelterService.checkout(rsvp);
        repository.deleteById(id);
    }

    public ReservationDTO getUserReservation(final long userId) {
        return mvcConversionService.convert(repository.findByUserId(userId).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(userId)))), ReservationDTO.class);
    }


    private Reservation fetchReservation(final long id) {
        return repository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id))));
    }

    private Reservation buildReservation(final User user, final ShelterDTO shelter) {
        return Reservation.builder()
                          .createdAt(Date.from(Instant.now()))
                          .expiresAt(Date.from(Instant.now().plusSeconds(7200)))
                          .shelter(mvcConversionService.convert(shelter, Shelter.class))
                          .user(user)
                          .build();
    }
}
