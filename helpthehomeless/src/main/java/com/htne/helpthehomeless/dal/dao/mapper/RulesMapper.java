package com.htne.helpthehomeless.dal.dao.mapper;

import com.htne.helpthehomeless.dal.model.Rules;
import com.htne.helpthehomeless.dto.RulesDTO;
import com.htne.helpthehomeless.dto.registration.validators.FieldValidator;

public class RulesMapper {
    public static Rules updateRules(final RulesDTO dto, final Rules rules) {
        if (dto.getCapacity() != rules.getCapacity()) {
            FieldValidator.validateField("capacity", String.valueOf(rules.getCapacity()));
            rules.setCapacity(dto.getCapacity());
        }

        if (!dto.getSupperTime().equals(rules.getSupperTime())) {
            rules.setSupperTime(dto.getSupperTime());
        }

        if (dto.isFemales() != rules.isFemales()) {
            rules.setFemales(dto.isFemales());
        }

        if (dto.isMales() != rules.isMales()) {
            rules.setMales(dto.isMales());
        }

        if (dto.isPets() != rules.isPets()) {
            rules.setPets(dto.isPets());
        }

        if (dto.isSober() != rules.isSober()) {
            rules.setSober(dto.isSober());
        }

        if (dto.isMinor() != rules.isMinor()) {
            rules.setMinor(dto.isMinor());
        }

        return rules;
    }
}
