package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.Rules;
import com.htne.helpthehomeless.dto.RulesDTO;

public class RulesToRulesDTOConverter {
    public static RulesDTO convert(final Rules source) {
        return RulesDTO.builder()
                       .checkoutTime(source.getCheckoutTime())
                       .females(source.isFemales())
                       .id(source.getId())
                       .males(source.isMales())
                       .pets(source.isPets())
                       .sober(source.isSober())
                       .capacity(source.getCapacity())
                       .checkinTime(source.getCheckinTime())
                       .minor(source.isMinor())
                       .supperTime(source.getSupperTime())
                       .build();
    }
}
