package com.htne.helpthehomeless.dto;

import lombok.*;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class UserDTO {
    private Long   id;
    private String username;
    private String email;
    private String firstName;
    private String lastName;
}