package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;

public class LocationDTOToLocationConverter {
    public static Location convert(final LocationDTO source) {
        return Location.builder()
                       .longitude(source.getLongitude())
                       .latitude(source.getLatitude())
                       .id(source.getId())
                       .placeId(source.getPlaceId())
                       .build();
    }
}
