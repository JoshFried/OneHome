package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.Rules;
import com.htne.helpthehomeless.dto.RulesDTO;

public class RulesDTOToRulesConverter {
    public static Rules convert(final RulesDTO source) {
        return Rules.builder()
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
