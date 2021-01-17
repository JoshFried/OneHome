package com.htne.helpthehomeless.dal.dao.mapper;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;
import com.htne.helpthehomeless.dto.registration.validators.FieldValidator;

public class LocationMapper {
    public static Location updateFields(final LocationDTO dto, final Location location) {

        if (dto.getLongitude() != location.getLongitude()) {
            FieldValidator.validateField("longitude", String.valueOf(dto.getLongitude()));
            location.setLongitude(dto.getLongitude());
        }

        if (dto.getLatitude() != location.getLatitude()) {
            FieldValidator.validateField("longitude", String.valueOf(dto.getLatitude()));
            location.setLatitude(dto.getLatitude());
        }

        return location;
    }
}
