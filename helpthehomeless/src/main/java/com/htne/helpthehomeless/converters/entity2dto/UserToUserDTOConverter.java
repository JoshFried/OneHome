package com.htne.helpthehomeless.converters.entity2dto;

import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(final User source) {
        return UserDTO.builder()
                      .id(source.getId())
                      .email(source.getEmail())
                      .username(source.getUsername())
                      .firstName(source.getFirstName())
                      .lastName(source.getLastName())
                      .isEnabled(source.isEnabled())
                      .role(source.getRole())
                      .age(source.getAge())
                      .gender(source.getGender())
                      .build();
    }
}