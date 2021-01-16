package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.LocationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ShelterDTOToShelterConverter implements Converter<ShelterDTO, Shelter> {

    @Override
    public Shelter convert(final ShelterDTO source) {
        return Shelter.builder()
                      .location(convertLocation(source.getLocation()))
                      .capacity(source.getCapacity())
//                      .id(source.getId())
                      .name(source.getName())
                      .occupancy(source.getOccupancy())
                      .webSite(source.getWebSite())
                      .build();
    }

    private static Location convertLocation(final LocationDTO source) {
        return Location.builder()
                       .city(source.getCity())
                       .country(source.getCountry())
                       .latitude(source.getLatitude())
                       .longitude(source.getLongitude())
                       .postalCode(source.getPostalCode())
                       .province(source.getProvince())
                       .streetLine1(source.getStreetLine1())
                       .streetLine2(source.getStreetLine2())
                       .build();
    }
}
