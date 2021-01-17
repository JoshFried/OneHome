package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Pickup;
import com.htne.helpthehomeless.dto.PickupDTO;
import org.springframework.core.convert.converter.Converter;

public class PickupToPickupDTOConverter implements Converter<Pickup, PickupDTO> {
    @Override
    public PickupDTO convert(Pickup pickup) {
        return PickupDTO.builder()
                .arrivalTime(pickup.getArrivalTime())
                .createdAt(pickup.getCreatedAt())
                .distance(pickup.getDistance())
                .id(pickup.getId())
                .reservation(pickup.getReservation())
                .user(pickup.getUser())
                .build();
    }

}
