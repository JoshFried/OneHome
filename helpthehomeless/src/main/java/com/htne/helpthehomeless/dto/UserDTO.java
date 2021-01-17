package com.htne.helpthehomeless.dto;

import com.htne.helpthehomeless.dal.model.Gender;
import com.htne.helpthehomeless.dal.model.Role;
import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {
    private Long    id;
    private String  username;
    private String  email;
    private String  firstName;
    private String  lastName;
    private Boolean isEnabled;
    private Role    role;
    private Gender  gender;
    private int     age;
}