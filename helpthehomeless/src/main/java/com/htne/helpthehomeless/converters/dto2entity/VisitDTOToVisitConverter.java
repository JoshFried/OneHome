package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dal.model.Visit;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import com.htne.helpthehomeless.dto.VisitDTO;
import org.springframework.core.convert.converter.Converter;

public class VisitDTOToVisitConverter implements Converter<VisitDTO, Visit> {
    @Override
    public Visit convert(final VisitDTO source) {
        return Visit.builder()
                    .date(source.getDate())
                    .shelter(convertShelter(source.getShelter()))
                    .user(convertUser(source.getUser()))
                    .build();
    }

    public static User convertUser(final UserDTO source) {
        return User.builder()
                   .email(source.getEmail())
                   .firstName(source.getFirstName())
                   .lastName(source.getLastName())
                   .username(source.getUsername())
                   .id(source.getId())
                   .isEnabled(source.getIsEnabled())
                   .role(source.getRole())
                   .age(source.getAge())
                   .gender(source.getGender())
                   .build();
    }

    public static Shelter convertShelter(final ShelterDTO source) {
        return Shelter.builder()
                      .id(source.getId())
                      .location(LocationDTOToLocationConverter.convert(source.getLocation()))
                      .name(source.getName())
                      .webSite(source.getWebSite())
                      .rules(RulesDTOToRulesConverter.convert(source.getRules()))
                      .build();
    }
}
