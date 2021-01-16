package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.converters.dto2entity.LocationDTOToLocationConverter;
import com.htne.helpthehomeless.dal.dao.LocationRepository;
import com.htne.helpthehomeless.dal.dao.ShelterRepository;
import com.htne.helpthehomeless.dal.dao.mapper.ShelterMapper;
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

        return mvcConversionService.convert(shelter, ShelterDTO.class);
    }

    public ShelterDTO getShelter(final long id) {
        return mvcConversionService.convert(fetchShelter(id), ShelterDTO.class);
    }

    public Shelter fetchShelter(final long id) {
        return shelterRepository.findById(id).orElseThrow(() -> new HTNENotFoundException(ExceptionHelper.getNotFoundExceptionMessage("Id: ", String.valueOf(id))));
    }

    public ShelterDTO incrementOccupancy(final long id) {
        final Shelter shelter = fetchShelter(id);
        shelter.setOccupancy(+1);
        return mvcConversionService.convert(shelterRepository.save(shelter), ShelterDTO.class);
    }

    public ShelterDTO updateShelter(final ShelterDTO dto) {
        shelterRepository.save(ShelterMapper.updateFields(dto, fetchShelter(dto.getId())));
        return dto;
    }

}
