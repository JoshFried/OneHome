package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;

public class LocationToLocationDTOConverter {
    public static LocationDTO convert(final Location source) {
        return LocationDTO.builder()
                          .id(source.getId())
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
