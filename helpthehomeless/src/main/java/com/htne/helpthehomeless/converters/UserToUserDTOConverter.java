package com.htne.helpthehomeless.converters;

import com.htne.helpthehomeless.dal.model.User;
import com.htne.helpthehomeless.dto.UserDTO;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Service;

@Service
public class UserToUserDTOConverter implements Converter<User, UserDTO> {
    @Override
    public UserDTO convert(final User user) {
        return UserDTO.builder()
                      .id(user.getId())
                      .email(user.getEmail())
                      .username(user.getUsername())
                      .firstName(user.getFirstName())
                      .lastName(user.getLastName())
                      .build();
    }
}