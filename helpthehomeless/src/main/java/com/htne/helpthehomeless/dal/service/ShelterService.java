package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.dal.dao.ShelterRepository;
import com.htne.helpthehomeless.dal.dao.mapper.ShelterMapper;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Role;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.events.AvailableSpotEventPublisher;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTHInvalidStateException;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.ReservationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import com.htne.helpthehomeless.dto.registration.ShelterRegistrationDTO;
import com.jayway.jsonpath.spi.json.GsonJsonProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelterService {
    private final ShelterRepository           shelterRepository;
    private final ConversionService           mvcConversionService;
    private final UserService                 userService;
    private final VisitService                visitService;
    private final AvailableSpotEventPublisher availableSpotEventPublisher;

    public ShelterDTO createShelter(final ShelterRegistrationDTO dto) {
        final User user = userService.getUserFromContext();

        if (user.getRole() != Role.ADMIN) {
            throw new HTNENotFoundException("Invalid Role");
        }

        final Shelter shelter = mvcConversionService.convert(dto, Shelter.class);
        shelter.setUser(user);
        shelterRepository.save(shelter);

        return mvcConversionService.convert(shelter, ShelterDTO.class);
    }

    public ShelterDTO getShelter(final long id) {
        return mvcConversionService.convert(fetchShelter(id), ShelterDTO.class);
    }

    public Shelter fetchShelter(final long id) {
        return shelterRepository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id))));
    }

    public ShelterDTO recieveVisitor(final long id, final UserDTO user) {
        final Shelter shelter = fetchShelter(id);
        RulesService.validateRules(user, shelter);
        shelter.getVisitors().add(mvcConversionService.convert(user, User.class));
        return mvcConversionService.convert(shelterRepository.save(shelter), ShelterDTO.class);
    }

    public ShelterDTO checkin(final ReservationDTO rsvp) {
        final Shelter shelter = fetchShelter(rsvp.getShelter().getId());
        shelter.getHistory().add(visitService.createVisit(rsvp));
        return mvcConversionService.convert(shelterRepository.save(shelter), ShelterDTO.class);
    }

    public ShelterDTO checkout(final Reservation rsvp) {
        rsvp.getShelter().getVisitors().remove(rsvp.getUser());
        availableSpotEventPublisher.publishEvent(rsvp.getShelter().getId());
        return mvcConversionService.convert(shelterRepository.save(rsvp.getShelter()), ShelterDTO.class);
    }

    public ShelterDTO addToWaitingList(final Long shelterId) {
        final User    user    = userService.getUserFromContext();
        final Shelter shelter = fetchShelter(shelterId);
        shelter.getWaitingList().add(user);
        return mvcConversionService.convert(shelterRepository.save(shelter), ShelterDTO.class);
    }

    public ShelterDTO updateShelter(final ShelterDTO dto) {
        final Shelter shelter = fetchShelter(dto.getId());
        final User    user    = userService.getUserFromContext();

        if (!user.equals(shelter.getUser())) {
            throw new HTHInvalidStateException("FUCK OFF");
        }

        shelterRepository.save(ShelterMapper.updateFields(dto, shelter));
        return dto;
    }


    public String getRegisteredSheltersWithinRadius(final double longitude, final double latitude, final int radius) {
        final List<Shelter> registeredShelterList = new ArrayList<>();

        for (final Shelter shelter : shelterRepository.findAll()) {
            if (distance(shelter.getLocation().getLatitude(),
                         shelter.getLocation().getLongitude(),
                         latitude, longitude,
                         "K")
                    <= radius / 1000) {
                registeredShelterList.add(shelter);
            }
            ;
        }

        return new GsonJsonProvider().toJson(registeredShelterList);
    }

    private static double distance(final double lat1, final double lon1, final double lat2, final double lon2, final String unit) {
        if ((lat1 == lat2) && (lon1 == lon2)) {
            return 0;
        } else {
            final double theta = lon1 - lon2;
            double       dist  = Math.sin(Math.toRadians(lat1)) * Math.sin(Math.toRadians(lat2)) + Math.cos(Math.toRadians(lat1)) * Math.cos(Math.toRadians(lat2)) * Math.cos(Math.toRadians(theta));
            dist = Math.acos(dist);
            dist = Math.toDegrees(dist);
            dist = dist * 60 * 1.1515;
            if (unit.equals("K")) {
                dist = dist * 1.609344;
            } else if (unit.equals("N")) {
                dist = dist * 0.8684;
            }
            return (dist);
        }
    }

}
