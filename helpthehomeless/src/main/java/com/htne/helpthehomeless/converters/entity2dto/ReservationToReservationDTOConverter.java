package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.ReservationDTO;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;

public class ReservationToReservationDTOConverter implements Converter<Reservation, ReservationDTO> {
    @Override
    public ReservationDTO convert(final Reservation source) {
        return ReservationDTO.builder()
                             .expiresAt(source.getExpiresAt())
                             .createdAt(source.getCreatedAt())
                             .id(source.getId())
                             .shelter(shelterConverter(source.getShelter()))
                             .user(userConverter(source.getUser()))
                             .build();
    }

    private static UserDTO userConverter(final User source) {
        return UserDTO.builder()
                      .id(source.getId())
                      .role(source.getRole())
                      .isEnabled(source.isEnabled())
                      .firstName(source.getFirstName())
                      .email(source.getEmail())
                      .username(source.getUsername())
                      .lastName(source.getLastName())
                      .build();
    }

    private static ShelterDTO shelterConverter(final Shelter source) {
        return ShelterDTO.builder()
                         .id(source.getId())
                         .location(LocationToLocationDTOConverter.convert(source.getLocation()))
                         .name(source.getName())
                         .webSite(source.getWebSite())
                         .rules(RulesToRulesDTOConverter.convert(source.getRules()))
                         .build();
    }
}
