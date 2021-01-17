package com.htne.helpthehomeless.dto;

import lombok.*;

import java.sql.Time;

@AllArgsConstructor
@Builder
@Getter
@Setter
@EqualsAndHashCode
public class RulesDTO {
    private Long    id;
    private Time    checkoutTime;
    private Time    supperTime;
    private Time    checkinTime;
    private int     capacity;
    private boolean males;
    private boolean females;
    private boolean pets;
    private boolean sober;
    private boolean minor;
}
