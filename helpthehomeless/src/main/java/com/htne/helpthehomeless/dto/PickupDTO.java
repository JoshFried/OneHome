package com.htne.helpthehomeless.dto;

import com.htne.helpthehomeless.dal.model.Reservation;
import com.htne.helpthehomeless.dal.model.User;
import lombok.*;
import java.util.Date;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class PickupDTO {
    private Long id;
    private Reservation reservation;
    private User user;
    private Date createdAt;
    private Date arrivalTime;
    private double distance;
}
