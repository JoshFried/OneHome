package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;

public class LocationToLocationDTOConverter {
    public static LocationDTO convert(final Location source) {
        return LocationDTO.builder()
                          .longitude(source.getLongitude())
                          .latitude(source.getLatitude())
                          .id(source.getId())
                          .placeId(source.getPlaceId())
                          .build();
    }
}
