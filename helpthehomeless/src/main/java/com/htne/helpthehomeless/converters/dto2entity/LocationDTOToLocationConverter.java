package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class LocationDTOToLocationConverter implements Converter<LocationDTO, Location> {
    @Override
    public Location convert(final LocationDTO source) {
        return Location.builder()
                       .streetLine2(source.getStreetLine2())
                       .province(source.getProvince())
                       .streetLine1(source.getStreetLine1())
                       .postalCode(source.getPostalCode())
                       .longitude(source.getLongitude())
                       .latitude(source.getLatitude())
                       .country(source.getCountry())
                       .city(source.getCity())
                       .build();
    }
}
