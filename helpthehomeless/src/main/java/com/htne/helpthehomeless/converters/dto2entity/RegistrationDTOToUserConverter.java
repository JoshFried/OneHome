package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.registration.UserRegistrationDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class RegistrationDTOToUserConverter implements Converter<UserRegistrationDTO, User> {

    @Override
    public User convert(final UserRegistrationDTO userRegistrationDTO) {
        return User.builder()
                   .email(userRegistrationDTO.getEmail())
                   .username(userRegistrationDTO.getUsername())
                   .password(userRegistrationDTO.getPassword())
                   .firstName(userRegistrationDTO.getFirstName())
                   .lastName(userRegistrationDTO.getLastName())
                   .role(userRegistrationDTO.getRole())
                   .gender(userRegistrationDTO.getGender())
                   .age(userRegistrationDTO.getAge())
                   .build();
    }
}