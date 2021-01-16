package com.htne.helpthehomeless.dal.dao.mapper;

import com.htne.helpthehomeless.dal.model.Location;
import com.htne.helpthehomeless.dto.LocationDTO;
import com.htne.helpthehomeless.dto.registration.validators.FieldValidator;

public class LocationMapper {
    public static Location updateFields(final LocationDTO dto, final Location location) {
        if (!dto.getStreetLine1().equals(location.getStreetLine1())) {
            FieldValidator.validateField("Streetline1", dto.getStreetLine1());
            location.setStreetLine1(dto.getStreetLine1());
        }
        if (!dto.getStreetLine2().equals(location.getStreetLine2())) {
            FieldValidator.validateField("Streetline2", dto.getStreetLine2());
            location.setStreetLine2(dto.getStreetLine2());
        }
        if (!dto.getPostalCode().equals(location.getPostalCode())) {
            FieldValidator.validateField("Postal Code", dto.getPostalCode());
            location.setPostalCode(dto.getPostalCode());
        }

        if (!dto.getProvince().equals(location.getProvince())) {
            FieldValidator.validateField("Province", dto.getProvince());
            location.setProvince(dto.getProvince());
        }

        if (!dto.getCity().equals(location.getCity())) {
            FieldValidator.validateField("City", dto.getCity());
            location.setCity(dto.getCity());
        }

        if (!dto.getCountry().equals(location.getCountry())) {
            FieldValidator.validateField("Country", dto.getCountry());
            location.setCountry(dto.getCountry());
        }

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
