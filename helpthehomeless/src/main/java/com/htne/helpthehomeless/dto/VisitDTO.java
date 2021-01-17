package com.htne.helpthehomeless.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class VisitDTO {
    private Long       id;
    private UserDTO    user;
    private ShelterDTO shelter;
    private Date       date;
}
