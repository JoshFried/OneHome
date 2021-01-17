package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.ShelterDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class ShelterDTOToShelterConverter implements Converter<ShelterDTO, Shelter> {

    @Override
    public Shelter convert(final ShelterDTO source) {
        return Shelter.builder()
                      .id(source.getId())
                      .location(LocationDTOToLocationConverter.convert(source.getLocation()))
                      .name(source.getName())
                      .webSite(source.getWebSite())
                      .rules(RulesDTOToRulesConverter.convert(source.getRules()))
                      .placeId(source.getPlaceId())
                      .build();
    }

}
