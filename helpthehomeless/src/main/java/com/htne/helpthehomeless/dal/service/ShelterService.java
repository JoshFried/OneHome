package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.converters.dto2entity.LocationDTOToLocationConverter;
import com.htne.helpthehomeless.dal.dao.LocationRepository;
import com.htne.helpthehomeless.dal.dao.ShelterRepository;
import com.htne.helpthehomeless.dal.model.Role;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.service.exceptions.ExceptionHelper;
import com.htne.helpthehomeless.dal.service.exceptions.HTNENotFoundException;
import com.htne.helpthehomeless.dto.ShelterDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ShelterService {
    private final ShelterRepository  shelterRepository;
    private final ConversionService  mvcConversionService;
    private final UserService        userService;
    private final LocationRepository locationRepository;

    public ShelterDTO createShelter(final ShelterDTO dto) {
        final User user = userService.getUserFromContext();

        if (user.getRole() != Role.ADMIN) {
            throw new HTNENotFoundException("Invalid Role");
        }

        locationRepository.save(LocationDTOToLocationConverter.convert(dto.getLocation()));
        final Shelter shelter = mvcConversionService.convert(dto, Shelter.class);
        shelter.setUser(user);
        shelterRepository.save(shelter);

        return dto;
    }

    public ShelterDTO getShelter(final long id) {
        return mvcConversionService.convert(shelterRepository
                                                    .findById(id)
                                                    .orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id)))),
                                            ShelterDTO.class);
    }

}
