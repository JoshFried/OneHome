package com.htne.helpthehomeless.dal.service;

import com.htne.helpthehomeless.converters.entity2dto.RulesToRulesDTOConverter;
import com.htne.helpthehomeless.dal.dao.RulesRepository;
import com.htne.helpthehomeless.dal.model.Gender;
import com.htne.helpthehomeless.dal.model.Rules;
import com.htne.helpthehomeless.dal.model.Shelter;
import com.htne.helpthehomeless.dal.service.exceptions.HTHInvalidStateException;
import com.htne.helpthehomeless.dto.RulesDTO;
import com.htne.helpthehomeless.dto.UserDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RulesService {
    private final RulesRepository rulesRepository;

    public RulesDTO createRules(final Rules rules) {
        return RulesToRulesDTOConverter.convert(rulesRepository.save(rules));
    }

    public static void validateRules(final UserDTO user, final Shelter shelter) {
        final Rules rules = shelter.getRules();

        validateGenders(user.getGender(), rules);
        validateAge(user.getAge(), rules.isMinor());

        if (shelter.getVisitors().size() >= rules.getCapacity()) {
            throw new HTHInvalidStateException("This shelter is currently full");
        }

    }

    private static void validateAge(final int age, final boolean minors) {
        if (minors && age >= 18) {
            throw new HTHInvalidStateException("This shelter is for minors only!");
        } else if (!minors && age < 18) {
            throw new HTHInvalidStateException("This shelter is for adults only!");
        }
    }

    private static void validateGenders(final Gender gender, final Rules rules) {
        if (!rules.isFemales() && gender == Gender.FEMALE) {
            throw new HTHInvalidStateException("This is a men's only shelter!");
        } else if (!rules.isMales() && gender == Gender.MALE) {
            throw new HTHInvalidStateException("This is a women's only shelter!");
        }
    }
}
