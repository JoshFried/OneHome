package com.htne.helpthehomeless.dto;

import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class ReservationDTO {
    private Long       id;
    private ShelterDTO shelter;
    private UserDTO    user;
    private Date       createdAt;
    private Date       expiresAt;
}
