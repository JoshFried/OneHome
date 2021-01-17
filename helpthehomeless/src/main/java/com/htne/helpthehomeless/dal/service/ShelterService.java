package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.converters.dto2entity.LocationDTOToLocationConverter;
import com.htne.helpthehomeless.converters.dto2entity.RulesDTOToRulesConverter;
import com.htne.helpthehomeless.dal.dao.LocationRepository;
import com.htne.helpthehomeless.dal.dao.ShelterRepository;
import com.htne.helpthehomeless.dal.dao.mapper.ShelterMapper;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Role;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.events.AvailableSpotEventPublisher;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.ReservationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShelterService {
    private final ShelterRepository           shelterRepository;
    private final ConversionService           mvcConversionService;
    private final UserService                 userService;
    private final LocationRepository          locationRepository;
    private final RulesService                rulesService;
    private final VisitService                visitService;
    private final AvailableSpotEventPublisher availableSpotEventPublisher;

    public ShelterDTO createShelter(final ShelterDTO dto) {
        final User user = userService.getUserFromContext();

        if (user.getRole() != Role.ADMIN) {
            throw new HTNENotFoundException("Invalid Role");
        }

        rulesService.createRules(RulesDTOToRulesConverter.convert(dto.getRules()));
        locationRepository.save(LocationDTOToLocationConverter.convert(dto.getLocation()));
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
        shelter.getVisitors().add(mvcConversionService.convert(user, User.class));
        RulesService.validateRules(user, shelter);
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

    public ShelterDTO updateShelter(final ShelterDTO dto) {
        shelterRepository.save(ShelterMapper.updateFields(dto, fetchShelter(dto.getId())));
        return dto;
    }

}
