package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.ShelterDTO;
import org.springframework.core.convert.converter.Converter;

public class ShelterToShelterDTOConverter implements Converter<Shelter, ShelterDTO> {
    @Override
    public ShelterDTO convert(final Shelter source) {
        return ShelterDTO.builder()
                         .id(source.getId())
                         .location(LocationToLocationDTOConverter.convert(source.getLocation()))
                         .name(source.getName())
                         .webSite(source.getWebSite())
                         .rules(RulesToRulesDTOConverter.convert(source.getRules()))
                         .build();
    }
}
