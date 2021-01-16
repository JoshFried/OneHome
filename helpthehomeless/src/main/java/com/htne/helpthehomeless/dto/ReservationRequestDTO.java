package com.htne.helpthehomeless.dto;

import lombok.Getter;

import java.util.Date;

@Getter
public class ReservationRequestDTO {
    private long shelterId;
    private Date expiresAt;
}
