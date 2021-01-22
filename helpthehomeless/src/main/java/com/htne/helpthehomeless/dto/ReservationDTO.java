package com.htne.helpthehomeless.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class ReservationDTO {
    private Long       id;
    private ShelterDTO shelter;
    private UserDTO    user;
    private Date       createdAt;
    private Date       expiresAt;
}
