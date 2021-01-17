package com.htne.helpthehomeless.dal.dao.mapper;

import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dto.ShelterDTO;
import com.htne.helpthehomeless.dto.registration.validators.FieldValidator;

public class ShelterMapper {
    public static Shelter updateFields(final ShelterDTO dto, final Shelter shelter) {
        shelter.setLocation(LocationMapper.updateFields(dto.getLocation(), shelter.getLocation()));
        shelter.setRules(RulesMapper.updateRules(dto.getRules(), shelter.getRules()));

        if (!dto.getWebSite().equals(shelter.getWebSite())) {
            FieldValidator.validateField("website", dto.getWebSite());
            shelter.setWebSite(dto.getWebSite());
        }
        if (!dto.getName().equals(shelter.getName())) {
            FieldValidator.validateField("website", dto.getName());
            shelter.setName(dto.getName());
        }

        return shelter;
    }
}
