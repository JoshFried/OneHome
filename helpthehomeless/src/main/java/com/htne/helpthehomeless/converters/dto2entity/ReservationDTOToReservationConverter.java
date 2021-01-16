package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.ReservationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import org.springframework.core.convert.converter.Converter;

public class ReservationDTOToReservationConverter implements Converter<ReservationDTO, Reservation> {
    @Override
    public Reservation convert(final ReservationDTO source) {
        return Reservation.builder()
                          .shelter(convertShelter(source.getShelter()))
                          .createdAt(source.getCreatedAt())
                          .expiresAt(source.getExpiresAt())
                          .build();
    }

    public static Shelter convertShelter(final ShelterDTO source) {
        return Shelter.builder()
                      .webSite(source.getWebSite())
                      .location(LocationDTOToLocationConverter.convert(source.getLocation()))
                      .occupancy(source.getOccupancy())
                      .name(source.getName())
                      .capacity(source.getCapacity())
                      .build();
    }

}
