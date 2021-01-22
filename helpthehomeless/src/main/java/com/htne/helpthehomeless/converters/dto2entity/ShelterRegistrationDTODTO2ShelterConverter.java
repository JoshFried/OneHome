package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dal.model.Rules;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.LocationDTO;
import com.htne.helpthehomeless.dto.registration.ShelterRegistrationDTO;
import org.springframework.core.convert.converter.Converter;

public class ShelterRegistrationDTODTO2ShelterConverter implements Converter<ShelterRegistrationDTO, Shelter> {
    @Override
    public Shelter convert(final ShelterRegistrationDTO source) {
        return Shelter.builder()
                      .location(convertLocation(source.getLocation()))
                      .name(source.getName())
                      .rules(Rules.builder().capacity(source.getCapacity()).build())
                      .webSite(source.getWebSite())
                      .build();
    }

    private Location convertLocation(final LocationDTO source) {
        return Location.builder()
                       .latitude(source.getLatitude())
                       .longitude(source.getLongitude())
                       .placeId(source.getPlaceId())
                       .build();
    }
}
