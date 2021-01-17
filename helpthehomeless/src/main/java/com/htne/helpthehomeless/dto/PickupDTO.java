package com.htne.helpthehomeless.dto;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.User;
import lombok.*;

import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.WRAPPER_OBJECT)
public class PickupDTO {
    private Long id;
    private Reservation reservation;
    private User user;
    private Date createdAt;
    private Date arrivalTime;
    private double distance;
}
