package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Pickup;
import com.htne.helpthehomeless.dto.PickupDTO;
import org.springframework.core.convert.converter.Converter;

public class PickupDTOToPickupConverter implements Converter<PickupDTO, Pickup> {
    @Override
    public Pickup convert(PickupDTO pickupDTO) {
        return Pickup.builder()
                .arrivalTime(pickupDTO.getArrivalTime())
                .createdAt(pickupDTO.getCreatedAt())
                .distance(pickupDTO.getDistance())
                .id(pickupDTO.getId())
                .reservation(pickupDTO.getReservation())
                .user(pickupDTO.getUser())
                .build();
    }
}
