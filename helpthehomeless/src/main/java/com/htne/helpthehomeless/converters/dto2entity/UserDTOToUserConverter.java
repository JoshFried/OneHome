package com.htne.helpthehomeless.converters.dto2entity;

import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserDTOToUserConverter implements Converter<UserDTO, User> {
    @Override
    public User convert(final UserDTO source) {
        return User.builder()
                   .email(source.getEmail())
                   .firstName(source.getFirstName())
                   .lastName(source.getLastName())
                   .username(source.getUsername())
                   .id(source.getId())
                   .isEnabled(source.getIsEnabled())
                   .role(source.getRole())
                   .build();
    }
}
