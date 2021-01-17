package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.model.Visit;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import com.htne.helpthehomeless.dto.VisitDTO;
import org.springframework.core.convert.converter.Converter;

public class VisitToVisitDTOConverter implements Converter<Visit, VisitDTO> {
    @Override
    public VisitDTO convert(final Visit source) {
        return VisitDTO.builder()
                       .date(source.getDate())
                       .id(source.getId())
                       .shelter(convertShelter(source.getShelter()))
                       .user(convertUser(source.getUser()))
                       .build();
    }

    private static UserDTO convertUser(final User source) {
        return UserDTO.builder()
                      .id(source.getId())
                      .email(source.getEmail())
                      .username(source.getUsername())
                      .firstName(source.getFirstName())
                      .lastName(source.getLastName())
                      .isEnabled(source.isEnabled())
                      .role(source.getRole())
                      .age(source.getAge())
                      .gender(source.getGender())
                      .build();
    }

    private static ShelterDTO convertShelter(final Shelter source) {
        return ShelterDTO.builder()
                         .id(source.getId())
                         .location(LocationToLocationDTOConverter.convert(source.getLocation()))
                         .name(source.getName())
                         .webSite(source.getWebSite())
                         .rules(RulesToRulesDTOConverter.convert(source.getRules()))
                         .build();
    }
}
