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
                      .location(LocationDTOToLocationConverter.convert(source.getLocation()))
                      .capacity(source.getCapacity())
                      .name(source.getName())
                      .occupancy(source.getOccupancy())
                      .webSite(source.getWebSite())
                      .build();
    }

}
